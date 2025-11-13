package com.example.javaplayground.order;

import java.util.List;

/**
 * Represents a single order consisting of one or more order items.
 */
public record Order(List<OrderItem> items) {

	public Order {
		items = items == null ? List.of() : List.copyOf(items);
	}
}

