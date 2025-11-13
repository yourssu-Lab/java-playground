package yourssu.order.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public Order() {
        items = new ArrayList<>();
    }


    public void addItem(OrderItem item) {
        items.add(item);
    }
}
