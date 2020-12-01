package com.onlineordering.order;

import com.onlineordering.model.Beverages;
import com.onlineordering.model.OrderItem;

import java.util.concurrent.atomic.AtomicInteger;

public class PrepareDrinks {
    private long hotDrinkDelay = 5000;
    private long coldDrinkDelay = 1000;

    private AtomicInteger hotDrinkCounter = new AtomicInteger();
    private AtomicInteger coldDrinkCounter = new AtomicInteger();

    public void setHotDrinkDelay(long hotDrinkDelay) {
        this.hotDrinkDelay = hotDrinkDelay;
    }

    public void setColdDrinkDelay(long coldDrinkDelay) {
        this.coldDrinkDelay = coldDrinkDelay;
    }

    public OrderItem prepareDrinks(OrderItem orderItem) {
        int quantity = orderItem.getQuantity();
        boolean isIced = Beverages.valueOf(orderItem.getItemName()).getIsIced();
        if(isIced) {
            for (int i = 0; i < quantity; i++)
                prepareColdDrink(orderItem);
        }
        else{
            for (int i = 0; i < quantity; i++)
                prepareHotDrink(orderItem);
        }
        return orderItem;
    }

    public void prepareHotDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.hotDrinkDelay);
            System.out.println(Thread.currentThread().getName()
                    + " prepared hot drink #" + hotDrinkCounter.incrementAndGet()
                    + " for order #" + orderItem.getOrderNumber()
                    + ": " + orderItem.getItemName());
            orderItem.setIsPrepared();
//            return orderItem;
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
//            return null;
        }
    }

    public void prepareColdDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.coldDrinkDelay);
            System.out.println(Thread.currentThread().getName()
                    + " prepared cold drink #" + coldDrinkCounter.incrementAndGet()
                    + " for order #" + orderItem.getOrderNumber() + ": "
                    + orderItem.getItemName());
//            return orderItem;
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
//            return null;
        }
    }
}
