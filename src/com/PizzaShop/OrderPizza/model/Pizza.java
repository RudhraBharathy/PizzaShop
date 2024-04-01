package com.PizzaShop.OrderPizza.model;

abstract class Pizza {

    static int takeAwayPrice = 50;
    static int extraToppingsAddOn = 75;
    static int extraCheeseAddOn = 100;

    protected abstract void addExtraToppings();

    protected abstract void addExtraCheese();

    protected abstract void deliveryType();

    public abstract void calculateBill();

}
