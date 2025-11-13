package yourssu.order.service;

import yourssu.user.domain.User;

import java.util.List;

public class OrderAnalyticsService {


    public double getAvgPrice(List<User> users) {
        double avgPrice = users.stream()
                .flatMap(user -> user.getOrders().stream())
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getPrice() * item.getCount())
                .average()
                .orElse(0.0);

        return avgPrice;
    }
}
