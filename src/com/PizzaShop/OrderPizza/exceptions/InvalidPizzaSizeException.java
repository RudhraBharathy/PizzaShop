package com.PizzaShop.OrderPizza.exceptions;
public class InvalidPizzaSizeException extends RuntimeException{
    private final static String INVALID_INPUT = "Invalid Pizza Type: ";

    public InvalidPizzaSizeException(String inputValue){
        super(inputValue);
    }

    @Override
    public String getMessage() {
        return INVALID_INPUT + super.getMessage();
    }
}
