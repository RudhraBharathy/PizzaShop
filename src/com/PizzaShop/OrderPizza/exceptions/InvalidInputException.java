package com.PizzaShop.OrderPizza.exceptions;

public class InvalidInputException extends RuntimeException{
    private final static String INVALID_INPUT = "Invalid Input: ";

    public InvalidInputException(String inputValue){
        super(inputValue);
    }

    @Override
    public String getMessage() {
        return INVALID_INPUT + super.getMessage();
    }
}
