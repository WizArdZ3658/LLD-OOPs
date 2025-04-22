package org.example.services;

import org.example.models.FoodItem;
import org.example.models.Order;
import org.example.models.Restaurant;

import java.util.List;

public interface FoodOrderingService {
    Order orderFood(Restaurant restaurant, FoodItem foodItem);
    void rateOrder(Order orderId, Double rating);
    List<Restaurant> getTopRestaurantsByFood(FoodItem foodItem);
    List<Restaurant> getTopRatedRestaurants();
}
