package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService cart;

    // Hiển thị giỏ hàng
    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "poly/lab5/index-cart";
    }

    // Thêm sản phẩm vào giỏ
    @RequestMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view";
    }

    // Xóa sản phẩm khỏi giỏ
    @RequestMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    // Cập nhật số lượng sản phẩm
    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @RequestParam("qty") Integer qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }

    // Xóa toàn bộ giỏ
    @RequestMapping("/cart/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}
