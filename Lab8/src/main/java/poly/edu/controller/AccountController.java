package poly.edu.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.service.CookieService;
import poly.edu.service.ParamService;
import poly.edu.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;

@Controller
public class AccountController {

    @Autowired
    ParamService paramService;

    @Autowired
    CookieService cookieService;

    @Autowired
    SessionService sessionService;

    /** Hiển thị form login */
    @GetMapping("/account/login")
    public String loginForm() {
        return "poly/lab5/login";
    }

    /** Xử lý đăng nhập */
    @PostMapping("/account/login")
    public String loginSubmit() {

        // Đọc các tham số từ form
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        // Kiểm tra đăng nhập (demo)
        if (username.equals("poly") && password.equals("123")) {
            // Lưu username vào session
            sessionService.set("username", username);

            // Xử lý ghi nhớ tài khoản
            if (remember) {
                cookieService.add("user", username, 10 * 24); // 10 ngày = 240h
            } else {
                cookieService.remove("user");
            }
            return "redirect:/account/success"; // chuyển sang trang thành công
        }

        // Nếu sai, quay lại form login
        return "redirect:/account/login";
    }

    /** Trang đăng nhập thành công */
    @GetMapping("/account/success")
    public String loginSuccess() {
        return "poly/lab5/success";
    }
    @GetMapping("/register")
    public String registerForm() {
        return "poly/lab5/register"; // Hiển thị form đăng ký
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("photo") MultipartFile photo) {
        // ✅ Lưu file upload vào thư mục /uploads/
        File savedFile = paramService.save(photo, "/uploads");

        System.out.println("Tên đăng ký: " + username);
        System.out.println("Mật khẩu: " + password);
        if (savedFile != null) {
            System.out.println("Ảnh đã lưu tại: " + savedFile.getAbsolutePath());
        } else {
            System.out.println("Chưa chọn ảnh để upload.");
        }

        return "redirect:/account/register";
    }
}
