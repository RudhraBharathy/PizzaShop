package com.PizzaShop.OrderPizza.model;

import java.util.List;

public class LargePizza extends Pizza {
    public final static String LARGE_PIZZA = "large";
    private static int vegPizzaPrice = 500;

    private static int nonVegPizzaPrice = 600;
    private int totalQuantity;

    private double totalBillAmount;
    private int toppingsBillAmount;
    private int cheesesBillAmount;
    private String pizzaSizeCommand;
    private String pizzaDeliveryType;

    private String pizzaTypeCommand;

    private List<String> extrasList;

    public LargePizza(String pizzaSizeCommand, String pizzaTypeCommand, List<String> extrasList, int pizzaQuantity, String pizzaDeliveryType) {
        this.pizzaSizeCommand = pizzaSizeCommand;
        this.totalQuantity = pizzaQuantity;
        this.pizzaDeliveryType = pizzaDeliveryType;
        this.pizzaTypeCommand = pizzaTypeCommand;
        this.extrasList = extrasList;
    }

    @Override
    protected void addExtraToppings() {
        this.toppingsBillAmount+=Pizza.extraToppingsAddOn;
    }

    @Override
    protected void addExtraCheese() {
        this.cheesesBillAmount+=Pizza.extraCheeseAddOn;
    }

    @Override
    protected void deliveryType() {
        this.totalBillAmount+=Pizza.takeAwayPrice;
    }

    @Override
    public void calculateBill() {
        if (pizzaTypeCommand.equals("veg")){
            this.totalBillAmount+=vegPizzaPrice;
        }else if (pizzaTypeCommand.equals("nonveg")){
            this.totalBillAmount+=nonVegPizzaPrice;
        }


        for (String extra : extrasList){
            if (extra.equals("--extratoppings")){
                addExtraToppings();
            }else if(extra.equals("--extracheese")){
                addExtraCheese();
            }
        }
        if (pizzaDeliveryType.equals("takeaway")){
            deliveryType();
        }
        totalBillAmount += toppingsBillAmount + cheesesBillAmount;
        totalBillAmount = this.totalBillAmount * totalQuantity;
        System.out.println("Your Order Summary:");
        System.out.println(pizzaSizeCommand+ " " +pizzaTypeCommand +" Pizza | Quantity: "+totalQuantity);
        System.out.println("Extra Toppings: "+toppingsBillAmount);
        System.out.println("Extra Cheese: "+cheesesBillAmount);
        String pizzaDeliveryTypeCapitalize = pizzaDeliveryType.substring(0,1).toUpperCase() + pizzaDeliveryType.substring(1).toLowerCase();
        if (pizzaDeliveryType.equals("takeaway")){
            System.out.println(pizzaDeliveryTypeCapitalize+": "+Pizza.takeAwayPrice);
        }else{
            System.out.println(pizzaDeliveryTypeCapitalize+": 0");
        }
        System.out.println("Total Amount: "+totalBillAmount);
    }
}
