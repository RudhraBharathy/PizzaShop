package com.PizzaShop.client;

import com.PizzaShop.OrderPizza.exceptions.InvalidInputException;
import com.PizzaShop.OrderPizza.executors.InputCommandExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInteraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                String userInput = scanner.nextLine();
                if (!userInput.isEmpty()) {
                    List<String> userInputSplit = Arrays.stream(userInput.split(" ")).collect(Collectors.toList());
                    InputCommandExecutor executor = new InputCommandExecutor(userInputSplit);
                    executor.validateInputs();
                    executor.makePizza(userInputSplit);
                }else{
                    throw new InvalidInputException("Enter Correct Input");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
