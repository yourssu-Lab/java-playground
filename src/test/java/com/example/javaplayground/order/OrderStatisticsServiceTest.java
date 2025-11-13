package com.example.javaplayground.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class OrderStatisticsServiceTest {

	private final OrderStatisticsService statisticsService = new OrderStatisticsService();

	@Test
	void calculatesAverageAcrossAllOrderItems() {
		var users = List.of(
				new User(List.of(new Order(List.of(new OrderItem("item-a", 100, 1),
						new OrderItem("item-b", 200, 2))))),
				new User(List.of(new Order(List.of(new OrderItem("item-c", 50, 4))))));

		var result = statisticsService.calculateAverageOrderAmount(users);

		assertThat(result).isPresent();
		assertThat(result.orElseThrow()).isEqualTo((100 + 400 + 200) / 3.0);
	}

	@Test
	void emptyWhenNoUsersProvided() {
		assertThat(statisticsService.calculateAverageOrderAmount(null)).isEmpty();
		assertThat(statisticsService.calculateAverageOrderAmount(List.of())).isEmpty();
	}
}

