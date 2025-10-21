package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import poly.edu.service.SessionService;

import java.util.Optional;

@Controller
public class ProductController1 {

    @Autowired
    ProductDAO dao;

    // Phân trang
    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "poly/page";
    }

    @Autowired
    SessionService session;
    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        String kwords = kw.orElse((String) session.get("keywords", ""));
        session.set("keywords", kwords);

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);

        model.addAttribute("page", page);
        return "poly/search-and-page";
    }


}
