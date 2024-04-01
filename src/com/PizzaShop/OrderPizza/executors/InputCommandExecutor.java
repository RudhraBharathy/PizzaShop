package com.PizzaShop.OrderPizza.executors;

import com.PizzaShop.OrderPizza.exceptions.InvalidInputException;
import com.PizzaShop.OrderPizza.exceptions.InvalidPizzaSizeException;
import com.PizzaShop.OrderPizza.model.LargePizza;
import com.PizzaShop.OrderPizza.model.MediumPizza;
import com.PizzaShop.OrderPizza.model.RegularPizza;
import com.PizzaShop.OrderPizza.validators.InputValidator;

import java.util.List;

public class InputCommandExecutor {
    private String pizzaSizeCommand;
    private String pizzaTypeCommand;
    List<String> extrasList;
    private int pizzaQuantity;

    private String pizzaDeliveryType;

    private boolean inputValidationCheck;

    public InputCommandExecutor(List<String> userInputSplit) {
        this.pizzaSizeCommand = userInputSplit.get(0);
        userInputSplit.remove(0);
        this.pizzaTypeCommand = userInputSplit.get(0);
        extrasList = userInputSplit.stream().filter(extra -> extra.contains("--")).toList();
        this.pizzaQuantity = Integer.parseInt(userInputSplit.get(userInputSplit.size()-2));
        this.pizzaDeliveryType = userInputSplit.get(userInputSplit.size()-1);
    }

    public void makePizza(List<String> userInputSplit){
        switch (pizzaSizeCommand) {
            case RegularPizza.REGULAR_PIZZA -> {
                RegularPizza regularPizza = new RegularPizza(pizzaSizeCommand,pizzaTypeCommand,extrasList,pizzaQuantity,pizzaDeliveryType);
                if (this.inputValidationCheck){
                    regularPizza.calculateBill();
                }
            }
            case MediumPizza.MEDIUM_PIZZA -> {
                MediumPizza mediumPizza = new MediumPizza(pizzaSizeCommand,pizzaTypeCommand,extrasList,pizzaQuantity,pizzaDeliveryType);
                if (this.inputValidationCheck){
                    mediumPizza.calculateBill();
                }
            }
            case LargePizza.LARGE_PIZZA -> {
                LargePizza largePizza = new LargePizza(pizzaSizeCommand,pizzaTypeCommand,extrasList,pizzaQuantity,pizzaDeliveryType);
                if (this.inputValidationCheck){
                    largePizza.calculateBill();
                }
            }
            case "exit" -> {
                break;
            }
            default -> throw new InvalidPizzaSizeException(userInputSplit.get(0));
        }
    }

    public void validateInputs() {
        InputValidator inputValidator = new InputValidator();
        this.inputValidationCheck = inputValidator.checkInputs(pizzaTypeCommand,extrasList,pizzaDeliveryType);
        try {
            if (!this.inputValidationCheck){
                throw new InvalidInputException("Enter Correct Input");
            }
        }catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
