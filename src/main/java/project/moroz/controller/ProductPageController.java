package project.moroz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.moroz.model.Product;
import project.moroz.service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductPageController {
    private ProjectService projectService;

    @Autowired
    public void setProjectService(@Qualifier("productProjectServiceImpl") ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ModelAndView getAllProducts() {
        List<Product> productsList = projectService.getList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products/products");
        modelAndView.addObject("productsList", productsList);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editPage(Model model, @PathVariable("id") int id) {
        Product product = (Product) projectService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products/editProduct");
        modelAndView.addObject("product", product);
        String form = "editForm";
        model.addAttribute("product", product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute("product") @Valid Product product,
                                    BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            System.out.println(product.getPage());
            modelAndView.setViewName("products/editProduct");
            modelAndView.addObject("product", product);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/product/");
        projectService.edit(product);
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView addPage(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products/editProduct");
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addProduct(@ModelAttribute("product") @Valid Product product,
                                   BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        product.setPage("add");
        if (bindingResult.hasErrors()){
            System.out.println(product.getPage());
            modelAndView.setViewName("products/editProduct");
            modelAndView.addObject("product", product);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/product/");
        projectService.add(product);
        product.setPage("");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = (Product) projectService.getById(id);
        modelAndView.setViewName("redirect:/product/");
        projectService.delete(product);
        return modelAndView;
    }
}
