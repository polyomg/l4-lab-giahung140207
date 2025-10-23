package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/home")
    public String userHome() {
        return "poly/lab8/user/home"; // JSP ở /WEB-INF/views/poly/lab8/user/home.jsp
    }
}

