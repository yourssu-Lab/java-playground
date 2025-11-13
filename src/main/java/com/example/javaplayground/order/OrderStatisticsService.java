package com.example.javaplayground.order;

import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

/**
 * Provides aggregation helpers for {@link User} order hierarchies.
 */
@Service
public class OrderStatisticsService {

	/**
	 * Calculates the global average of {@code price * count} across all order items
	 * owned by the provided users.
	 *
	 * @param users the users to inspect
	 * @return an {@link OptionalDouble} containing the average when at least one item
	 * is present
	 */
	public OptionalDouble calculateAverageOrderAmount(List<User> users) {
		if (users == null) {
			return OptionalDouble.empty();
		}

		return users.stream()
			.filter(Objects::nonNull)
			.flatMap(user -> user.orders().stream())
			.flatMap(order -> order.items().stream())
			.mapToDouble(orderItem -> orderItem.price() * orderItem.count())
			.average();
	}
}

