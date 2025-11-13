package com.example.javaplayground;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.javaplayground.order.Order;
import com.example.javaplayground.order.OrderItem;
import com.example.javaplayground.order.OrderStatisticsService;
import com.example.javaplayground.order.User;

@SpringBootApplication
public class JavaPlaygroundApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaPlaygroundApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaPlaygroundApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(OrderStatisticsService statisticsService) {
		return args -> {
			var users = List.of(
					new User(List.of(new Order(List.of(
							new OrderItem("Keyboard", 120_00, 1),
							new OrderItem("Mouse", 45_00, 2))))),
					new User(List.of(
							new Order(List.of(new OrderItem("Monitor", 320_00, 1))),
							new Order(List.of(new OrderItem("USB-C Cable", 15_00, 3))))));

			statisticsService.calculateAverageOrderAmount(users)
				.ifPresentOrElse(
						avg -> log.info("Average order amount (price * count) across all items: {}", avg / 100.0),
						() -> log.info("No order items available to calculate an average."));
		};
	}

}
