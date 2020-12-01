package com.onlineordering.order;

import com.onlineordering.model.Order;
import com.onlineordering.model.OrderItem;

import java.util.List;

public class ProcessItemsForOrder {
    public Order processItems(List<OrderItem> orderItemList){
        Order order = new Order();
        order.setOrderItems(orderItemList);
        order.setOrderId(orderItemList.get(0).getOrderNumber());

        System.out.println("***** order items in order :" + order.getOrderId());
        for(OrderItem item:orderItemList){
            System.out.println(" item : " + item.getItemName());
        }
        return order;
    }
}
