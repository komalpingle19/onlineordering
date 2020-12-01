package com.onlineordering.order;

import com.onlineordering.model.Beverages;
import com.onlineordering.model.Order;

import com.onlineordering.model.OrderItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DominosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		PollableChannel channel = (PollableChannel) context.getBean("orderInputChannel");
//		PollableChannel coldDrinksChannel = (PollableChannel) context.getBean("coldDrinksChannel");
//		PollableChannel hotDrinksChannel = (PollableChannel) context.getBean("hotDrinksChannel");
		PollableChannel aggregatedOrderChannel = (PollableChannel) context.getBean("aggregatedOrderChannel");

		Order order = new Order();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		order.setOrderTime(timestamp);
		order.setOrderId(123);

		OrderItem item1 = new OrderItem();
		item1.setOrderNumber(order.getOrderId());
		item1.setItemName(Beverages.ICE_TEA.name());
		item1.setQuantity(1);
//		item1.setIced(true);

		OrderItem item2 = new OrderItem();
		item2.setOrderNumber(order.getOrderId());
		item2.setItemName(Beverages.FILTER_COFFEE.name());
		item2.setQuantity(1);
//		item2.setIced(false);

		OrderItem item3 = new OrderItem();
		item3.setOrderNumber(order.getOrderId());
		item3.setItemName(Beverages.HOT_CHOCOLATE.name());
		item3.setQuantity(1);
//		item3.setIced(false);

		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(item1);
		orderItems.add(item2);
		orderItems.add(item3);

		order.setOrderItems(orderItems);

		Order order2 = new Order();
		 timestamp = new Timestamp(System.currentTimeMillis());
		order2.setOrderTime(timestamp);
		order2.setOrderId(1234);

		OrderItem item4 = new OrderItem();
		item4.setOrderNumber(order2.getOrderId());
		item4.setItemName(Beverages.CLASSIC_LEMONADE.name());
		item4.setQuantity(1);
//		item4.setIced(true);

		List<OrderItem> orderItemList2 = new ArrayList<>();
		orderItemList2.add(item4);

		order2.setOrderItems(orderItemList2);

		channel.send(MessageBuilder.withPayload(order).build());
		channel.send(MessageBuilder.withPayload(order2).build());
//		Message<?> coldDrink = coldDrinksChannel.receive();
//		Message<?> hotDrink = hotDrinksChannel.receive();

//		System.out.println("**** coldDrinkChannel received: " + coldDrink);
//		System.out.println("**** hotDrinksOutputChannel received: " + hotDrink);

//		Message<?> hotDrink = hotDrinksOutputChannel.receive();
//		System.out.println("**** hotDrink received: " + hotDrink);

//		Message<?> preparedDrinks1 = preparedDrinksChannel.receive();
//		Message<?> preparedDrinks2 = preparedDrinksChannel.receive();

		Message<?> aggregatedOrder = aggregatedOrderChannel.receive();

		System.out.println("prepared order : " + aggregatedOrder.getPayload().toString());

		Message<?> aggregatedOrder2 = aggregatedOrderChannel.receive();

		System.out.println("prepared order : " + aggregatedOrder2.getPayload().toString());
//		System.out.println("prepared order : " + preparedDrinks2.getPayload());
		Scanner sc =new Scanner(System.in);

	}
}
