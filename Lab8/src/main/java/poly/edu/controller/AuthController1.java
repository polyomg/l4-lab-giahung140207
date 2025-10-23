package poly.edu.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.entity.Account;
import poly.edu.service.AccountService;

@Controller
public class AuthController1 {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    // Hiển thị form login
    @GetMapping("/auth/login")
    public String loginForm(Model model) {
        return "poly/lab8/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/auth/login")
    public String loginProcess(Model model,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password) {

        Account user = accountService.findById(username);

        if (user == null) {
            model.addAttribute("message", "Invalid username!");
            return "poly/lab8/login";
        } else if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Invalid password!");
            return "poly/lab8/login";
        } else {
            session.setAttribute("user", user);
            model.addAttribute("message", "Login successfully!");

            // Nếu có URI bảo mật trước đó, quay lại đó
            String securityUri = (String) session.getAttribute("securityUri");
            if (securityUri != null) {
                return "redirect:" + securityUri;
            }

            if (user.isAdmin()) {
                return "redirect:/admin/home1";
            }
            return "redirect:/user/home";


        }
    }
}
