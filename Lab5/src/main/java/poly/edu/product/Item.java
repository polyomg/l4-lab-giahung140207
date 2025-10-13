package poly.edu.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;
    private String name;
    private double price;
    private int qty = 1;

    public double getAmount() {
        return price * qty;
    }
}
