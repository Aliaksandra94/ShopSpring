//package project.moroz.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import project.moroz.model.BasketItem;
//import project.moroz.model.User;
//import project.moroz.service.BasketProjectService;
//
//import java.util.List;
//
//@Controller
//@SessionAttributes({"user", "listOfProductsInBasket"})
//@RequestMapping("/basket")
//public class BasketPageController {
//    private BasketProjectService projectService;
//
//    @Autowired
//    public void setProjectService(BasketProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @ModelAttribute("listOfProductsInBasket")
//    public List<BasketItem> productList(@ModelAttribute("user") User user) {
//        return projectService.returnListOfProductsInBasket(user);
//    }
//
//    @GetMapping("/")
//    public ModelAndView showBasket(@ModelAttribute("user") User user, Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("basket/basket");
//        model.addAttribute("listOfProductsInBasket", projectService.returnListOfProductsInBasket(user));
//        return modelAndView;
//    }
//
//    @PostMapping("/")
//    public ModelAndView editCount(@ModelAttribute("user") User user, @RequestParam("count") int count,
//                                  @RequestParam("product_id") int productID) {
//        ModelAndView modelAndView = new ModelAndView();
//        projectService.updateCount(user, productID, count);
//        modelAndView.setViewName("redirect:/basket");
//        return modelAndView;
//    }
//
//    @GetMapping("/")
//    public ModelAndView deleteItem(@ModelAttribute("user") User user, @RequestParam("product_id") int productID) {
//        ModelAndView modelAndView = new ModelAndView();
//        projectService.deleteItem(user, productID);
//        modelAndView.setViewName("redirect:/basket");
//        return modelAndView;
//    }
//}
