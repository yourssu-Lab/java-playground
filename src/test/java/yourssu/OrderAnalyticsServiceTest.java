package yourssu;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import yourssu.order.domain.Order;
import yourssu.order.domain.OrderItem;
import yourssu.order.service.OrderAnalyticsService;
import yourssu.user.domain.User;

import java.util.List;

public class OrderAnalyticsServiceTest {

    private final OrderAnalyticsService orderAnalyticsService = new OrderAnalyticsService();

    @Test
    void 평균_주문_금액을_구한다() {
        // given
        List<User> users = List.of(
                new User(List.of(
                        new Order(List.of(
                                new OrderItem("A", 1000, 2),
                                new OrderItem("B", 1500, 1)
                        )),
                        new Order(List.of(
                                new OrderItem("C", 500, 3)
                        ))
                )),
                new User(List.of(
                        new Order(List.of(
                                new OrderItem("D", 2000, 1),
                                new OrderItem("E", 800, 2)
                        ))
                ))
        );

        // when
        double testAvg = orderAnalyticsService.getAvgPrice(users);

        // then

        assertThat(testAvg).isEqualTo(1720.0);
    }
}
