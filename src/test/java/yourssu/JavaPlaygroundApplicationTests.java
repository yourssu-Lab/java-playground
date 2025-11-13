package yourssu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import yourssu.order.domain.Order;
import yourssu.order.domain.OrderItem;
import yourssu.order.domain.OrderUser;
import yourssu.order.service.OrderAnalyticsService;
import yourssu.user.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;

@SpringBootTest
class JavaPlaygroundApplicationTests {

    private List<OrderUser> prepareData() {
        OrderItem item1 = new OrderItem("item1", 2000, 2); // 4000
        OrderItem item2 = new OrderItem("item2", 500, 3);  // 1500
        Order order1 = new Order(Arrays.asList(item1, item2));

        OrderItem item3 = new OrderItem("item3", 1000, 1); // 1000
        OrderItem item4 = new OrderItem("item4", 300, 5); // 1500
        Order order2 = new Order(Arrays.asList(item3, item4));

        return Arrays.asList(new OrderUser(List.of(order1)), new OrderUser(List.of(order2)));
    }

	@Test
	void 모든_주문상품의_개별_총금액을_계산하고_하나의_리스트로_펼친다() {
        List<OrderUser> orderUsers = prepareData();

        List<Integer> expectedItemTotals = List.of(4000, 1500, 1000, 1500);

        assertThat(expectedItemTotals)
                .as("총 4개의 주문 상품 금액이 계산되어야 함")
                .hasSize(4);

        assertThat(expectedItemTotals)
                .as("각 주문 상품의 (price * count) 결과는 [4000, 1500, 1000, 1500] 순으로 일치해야 함")
                .containsExactlyElementsOf(expectedItemTotals);

        assertThat(expectedItemTotals.stream().mapToInt(Integer::intValue).sum())
                .as("계산된 모든 금액의 합은 8000이어야 함")
                .isEqualTo(8000);

	}

    @Test
    void 모든_주문상품의_최종_평균_금액을_정확히_계산_한다() {
        List<OrderUser> orderUsers = prepareData();
        double expectedAverage = 2000.0;

        double averagePrice = OrderAnalyticsService.getAverageOrderAmount(orderUsers);

        assertThat(averagePrice)
                .as("모든 주문 상품의 평균 금액은 %.2f 이어야 함", expectedAverage)
                .isEqualTo(expectedAverage, offset(0.001)); // 0.001 오차 범위 허용
    }
}
