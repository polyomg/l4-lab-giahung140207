package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.DAO.ProductDAO;
import poly.edu.entity.Report;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    ProductDAO dao;
    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "poly/lab7/inventory-by-category";
    }
}
