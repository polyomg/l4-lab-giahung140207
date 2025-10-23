package poly.edu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.edu.model.Item;
import poly.edu.db.DB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // Dùng Map để chứa các mặt hàng (id, item)
    private Map<Integer, Item> map = new HashMap<>();

    // Thêm mặt hàng vào giỏ
    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            // Lấy thông tin sản phẩm từ "database" giả lập
            Item dbItem = DB.items.get(id);
            if (dbItem != null) {
                item = new Item(dbItem.getId(), dbItem.getName(), dbItem.getPrice(), 1);
                map.put(id, item);
            }
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    // Xóa mặt hàng khỏi giỏ
    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    // Cập nhật số lượng sản phẩm
    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
            if (qty <= 0) {
                map.remove(id);
            }
        }
        return item;
    }

    // Xóa toàn bộ giỏ
    @Override
    public void clear() {
        map.clear();
    }

    // Lấy danh sách mặt hàng trong giỏ
    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    // Tổng số lượng sản phẩm
    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    // Tổng tiền của giỏ hàng
    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(Item::getAmount)
                .sum();
    }
}
