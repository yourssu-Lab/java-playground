package yourssu.user.domain;

import yourssu.order.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderUser {
    private final List<Order> orders;

    public OrderUser() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
