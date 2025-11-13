package yourssu.order.domain;

import java.util.List;

public class OrderUser {
    private final List<Order> orders;

    public OrderUser(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
