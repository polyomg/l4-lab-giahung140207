package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    HttpServletRequest request;

    // Hiển thị form nhập
    @GetMapping("/rectangle/form")
    public String form() {
        return "poly/rectangle";
    }

    // Xử lý tính toán
    @PostMapping("/rectangle/calc")
    public String calc(Model model) {
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));

        if (width > length) {
            double temp = length;
            length = width;
            width = temp;
        }

        double area = length * width;
        double perimeter = 2 * (length + width);

        String areaExpr = length + " * " + width + " = " + area;
        String perimeterExpr = "2 * (" + length + " + " + width + ") = " + perimeter;

        model.addAttribute("areaExpr", areaExpr);
        model.addAttribute("perimeterExpr", perimeterExpr);
        model.addAttribute("length", length);
        model.addAttribute("width", width);

        return "poly/rectangle";
    }
}
