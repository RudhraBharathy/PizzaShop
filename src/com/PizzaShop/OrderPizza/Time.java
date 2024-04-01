package com.PizzaShop.OrderPizza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Time {
    LocalDate localDate = LocalDate.now();
    List<String> weeks = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    String week = weeks.get(localDate.getDayOfWeek().getValue()-1);
}
