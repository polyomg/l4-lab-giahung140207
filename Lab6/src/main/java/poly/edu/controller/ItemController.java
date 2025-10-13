package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.db.DB;

@Controller
public class ItemController {

    @RequestMapping("/item/index")
    public String list(Model model) {
        model.addAttribute("items", DB.items.values());
        return "poly/lab5/index-item"; // Trả về view hiển thị danh sách hàng hóa
    }
}
