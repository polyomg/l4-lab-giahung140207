package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/home1")
    public String adminHome() {
        return "poly/lab8/admin/home1"; // JSP nằm ở /WEB-INF/views/poly/lab8/admin/home1.jsp
    }
}

