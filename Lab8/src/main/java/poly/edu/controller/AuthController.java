package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    HttpServletRequest request;

    // Hiển thị form login
    @GetMapping("/login/form")
    public String form(Model model) {
        model.addAttribute("message", "Vui lòng đăng nhập");
        return "poly/login";
    }

    // Xử lý khi submit form
    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại, sai username hoặc password.");
        }
        return "poly/login";
    }
}
