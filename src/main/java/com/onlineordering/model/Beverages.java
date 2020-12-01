package com.onlineordering.model;

public enum Beverages {
    FILTER_COFFEE (false),
    HOT_CHOCOLATE (false),
    ICE_TEA (true),
    GINGER_TEA (false),
    CLASSIC_LEMONADE (true),
    COOL_BLUE (true),
    LATTE (false);

     final boolean isIced;

    private Beverages(boolean isIced){
        this.isIced=isIced;
    }

    public boolean getIsIced(){
        return isIced;
    }
}
