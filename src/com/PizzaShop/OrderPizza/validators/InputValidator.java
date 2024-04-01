package com.PizzaShop.OrderPizza.validators;

import java.util.HashMap;
import java.util.List;

public class InputValidator {
    HashMap<Integer,String> inputsValidation;

    public InputValidator() {
        inputsValidation = new HashMap<>();
        inputsValidation.put(1, "veg");
        inputsValidation.put(2, "nonveg");
        inputsValidation.put(3, "--extracheese");
        inputsValidation.put(4, "--extratoppings");
        inputsValidation.put(5, "takeaway");
        inputsValidation.put(6, "dinein");
    }


    public boolean checkInputs(String pizzaTypeCommand, List<String> extrasList, String pizzaDeliveryType) {
        int extrasCount = 0;
        if (!extrasList.isEmpty()){
            for (String extra :extrasList){
                if (inputsValidation.containsValue(extra)){
                    extrasCount++;
                }
            }
        }
        if (extrasList.isEmpty()){
            return inputsValidation.containsValue(pizzaTypeCommand) &&
                    inputsValidation.containsValue(pizzaDeliveryType);
        }else{
            return inputsValidation.containsValue(pizzaTypeCommand) &&
                    inputsValidation.containsValue(pizzaDeliveryType) &&
                    extrasCount == extrasList.size();
        }
    }
}
