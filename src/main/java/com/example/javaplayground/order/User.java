package com.example.javaplayground.order;

import java.util.List;

/**
 * Simple aggregate root that owns the orders placed by a user.
 */
public record User(List<Order> orders) {

	public User {
		orders = orders == null ? List.of() : List.copyOf(orders);
	}
}

