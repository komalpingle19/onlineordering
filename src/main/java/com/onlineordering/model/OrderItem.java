package com.onlineordering.model;

public class OrderItem {

    int orderNumber;
    String itemName;
    int quantity;
    int size;
//    boolean isIced;
    boolean isPrepared;

    public boolean setIsPrepared() {
        return isPrepared;
    }

    public void getIsPrepared(boolean prepared) {
        this.isPrepared = isPrepared;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public boolean isIced() {
//        return isIced;
//    }
//
//    public void setIced(boolean iced) {
//        isIced = iced;
//    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderNumber=" + orderNumber +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", size=" + size +
//                ", isIced=" + isIced +
                ", isPrepared=" + isPrepared +
                '}';
    }
}
