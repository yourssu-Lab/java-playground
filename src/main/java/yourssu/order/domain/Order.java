package yourssu.order.domain;

import java.util.List;

public class Order {
    private final List<OrderItem> items;

    public Order(List<OrderItem> items) {
        this.items = items;
    }
}
