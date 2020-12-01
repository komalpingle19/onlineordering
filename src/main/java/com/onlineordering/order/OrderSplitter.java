package com.onlineordering.order;

import com.onlineordering.model.Order;
import com.onlineordering.model.OrderItem;

import java.util.List;

public class OrderSplitter {
    public List<OrderItem> split(Order order) {

        System.out.println("***** Splitting orders : " + order.getOrderItems().size());
        return order.getOrderItems();
    }
}