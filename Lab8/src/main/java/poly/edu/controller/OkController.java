package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "poly/ok";
    }

    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("method", "M1");
        return "poly/ok";
    }

    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("method", "M2");
        return "poly/ok";
    }

    @PostMapping("/ctrl/ok/{x}")
    public String m3(@PathVariable("x") Integer x, Model model) {
        model.addAttribute("method", "M3: x=" +x);
        return "poly/ok";
    }
}
