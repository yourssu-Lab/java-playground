package com.example.javaplayground.order;

/**
 * Represents a purchasable line item within an order.
 *
 * @param name  item name for display
 * @param price unit price (assumed to be in the smallest currency unit)
 * @param count purchased quantity
 */
public record OrderItem(String name, int price, int count) {

	public int totalPrice() {
		return price * count;
	}
}

