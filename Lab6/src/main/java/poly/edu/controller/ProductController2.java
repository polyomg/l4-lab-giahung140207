package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController2 {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        model.addAttribute("field", field.orElse("price").toUpperCase());
        return "poly/sort";
    }
}
