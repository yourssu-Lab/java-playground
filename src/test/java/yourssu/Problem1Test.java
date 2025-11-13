package yourssu;

import org.junit.jupiter.api.Test;
import yourssu.order.domain.Order;
import yourssu.order.domain.OrderItem;
import yourssu.order.service.OrderAnalyticsService;
import yourssu.user.domain.OrderUser;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

public class Problem1Test {

    @Test
    void calculationAverage() {
        // given
        Order order1 = new Order();
        order1.addItem(new OrderItem("A", 1000, 3));
        order1.addItem(new OrderItem("B", 2000, 6));

        Order order2 = new Order();
        order2.addItem(new OrderItem("A", 1000, 3));
        order2.addItem(new OrderItem("B", 2000, 6));

        OrderUser user = new OrderUser();
        user.addOrder(order1);
        user.addOrder(order2);

        OrderAnalyticsService service = new OrderAnalyticsService();
        // when
        double averageCost = service.calculateAverageCost(user.getOrders());

        // then
        assertThat(averageCost).isCloseTo(15000 / 9F, byLessThan(0.0001));
    }
}
