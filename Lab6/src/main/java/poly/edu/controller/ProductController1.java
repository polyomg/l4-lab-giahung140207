package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController1 {

    @Autowired
    ProductDAO dao;

    // Phân trang
    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {
        // p.orElse(0): nếu không có tham số p thì mặc định là trang 0
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "poly/page";
    }
}
