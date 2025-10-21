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
        Sort sort = Sort.by(Sort.Direction.ASC, field.orElse("price"));
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        model.addAttribute("field", field.orElse("price").toUpperCase());
        return "poly/sort";
    }
    @RequestMapping("/product/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {

        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);

        model.addAttribute("items", items);
        return "poly/search";
    }

}
