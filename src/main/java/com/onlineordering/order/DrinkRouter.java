package com.onlineordering.order;

import com.onlineordering.model.Beverages;
import com.onlineordering.model.OrderItem;

public class DrinkRouter {
    public String resolveOrderItemChannel(OrderItem orderItem) {
        System.out.println("**** in Drink Router class");
        Beverages beverage = Beverages.valueOf(orderItem.getItemName());
        return beverage.getIsIced() ? "coldDrinksChannel" : "hotDrinksChannel";
    }
}
