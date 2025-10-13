package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
    @RequestMapping("/poly/hello")
    public String hello(Model model){
        model.addAttribute("title", "FPT Polythechnic");
        model.addAttribute("subject", "Spring boot MVC - Nguyen Gia Hung L3");
        return "poly/hello";
    }
}
