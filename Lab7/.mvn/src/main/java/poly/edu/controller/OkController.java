package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "poly/ok";
    }
    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("method", "m1()");
        return "poly/ok";
    }
    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2()");
        return "poly/ok";
    }
    @PostMapping(value = "/ctrl/ok", params = "x")
    public String m3(@RequestParam("x") String x, Model model) {
        model.addAttribute("method", "m3(x=" + x + ")");
        return "poly/ok";
    }
}
