package yourssu.user.domain;

import java.util.List;

import yourssu.order.domain.Order;
import yourssu.order.domain.OrderItem;
import yourssu.post.domain.Post;

public class User {

    private final List<Order> orders;



    public User(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
