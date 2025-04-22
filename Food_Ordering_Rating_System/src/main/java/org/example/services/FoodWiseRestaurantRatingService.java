package org.example.services;

import org.example.models.FoodItem;
import org.example.models.Restaurant;

import java.util.List;

public interface FoodWiseRestaurantRatingService {
    List<Restaurant> getTopRestaurantsForFoodItem(FoodItem foodItem);
}
