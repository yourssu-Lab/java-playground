package yourssu.order.service;

import yourssu.order.domain.Order;
import yourssu.order.domain.OrderItem;

import java.util.List;

public class OrderAnalyticsService {

    public double calculateAverageCost(List<Order> orders) {
        int totalPrice = orders.stream().flatMap(order -> order.getItems().stream())
                .mapToInt(OrderItem::calculateTotalPrice)
                .sum();

        int count = orders.stream().flatMap(order -> order.getItems().stream())
                .mapToInt(OrderItem::getCount)
                .sum();

        return totalPrice / (double) count;
    }
}
