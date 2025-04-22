package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.OrderStatus;

@Getter
@Setter
public class Order {
    private OrderStatus orderStatus;
    private Integer id;
    private Restaurant restaurant;
    private FoodItem foodItem;
    private Double amount;
}
