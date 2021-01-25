package project.moroz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.moroz.model.Role;
import project.moroz.model.User;
import project.moroz.service.ProjectService;
import project.moroz.service.UserProjectService;

import java.util.List;

@Controller
public class MainPageController {
    @GetMapping("/")
    public ModelAndView startPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("startPage");
        return modelAndView;
    }
}