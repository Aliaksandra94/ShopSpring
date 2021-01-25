package project.moroz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.moroz.model.Role;
import project.moroz.model.User;
import project.moroz.service.ProjectService;
import project.moroz.service.UserProjectService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {
    private UserProjectService projectService;

    @Autowired
    public void setProjectService(@Qualifier("userProjectServiceImpl") UserProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ModelAndView getAllUsers() {
        List<User> users = projectService.getList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/users");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(Model model, @PathVariable("id") int id) {
        User user = (User) projectService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/editUser");
        modelAndView.addObject("user", user);
        model.addAttribute("user", user);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editUser(@ModelAttribute("user") @Valid User user,
                                 BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("users/editUser");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/user/");
        projectService.edit(user);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/editUser");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> rolesList = projectService.getRoleList();
        modelAndView.addObject("roles", rolesList);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("users/editUser");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        if (!projectService.checkUserLogin(user.getLogin())) {
            modelAndView.setViewName("redirect:/user/");
            projectService.add(user);
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) projectService.getById(id);
        modelAndView.setViewName("redirect:/user/");
        projectService.delete(user);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/loginPage");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam("login") String login,
                                  @RequestParam("pass") String pass,
                                  Model model) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) projectService.checkUserByLoginAndPassword(login, pass);
        if (user != null) {
            model.addAttribute("user", user);
            modelAndView.setViewName("users/mainPage");
        } else {
            modelAndView.setViewName("users/loginPage");
        }
        return modelAndView;
    }
}