package yourssu.order.service;

import yourssu.order.domain.OrderUser;

import java.util.List;
import java.util.stream.Collectors;

public class OrderAnalyticsService {
    public static double getAverageOrderAmount(List<OrderUser> user) {
        return user.stream()
                .flatMap(orderUser -> orderUser.getOrders().stream())
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.averagingDouble(
                        orderItem -> orderItem.getCount() * orderItem.getPrice()
                ));
    }
}
