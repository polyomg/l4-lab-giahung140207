package poly.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", p);
        model.addAttribute("p2", new Product());
        model.addAttribute("items", items);
        return "poly/product";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        Product defaultP = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", defaultP);

        items.add(new Product(p.getName(), p.getPrice()));

        model.addAttribute("p2", p);
        model.addAttribute("items", items);
        return "poly/product";
    }

    private List<Product> items = new ArrayList<>(
            Arrays.asList(new Product("A", 1.0), new Product("B", 12.0))
    );
}

