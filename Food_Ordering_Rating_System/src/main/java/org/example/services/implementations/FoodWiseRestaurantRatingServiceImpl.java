package org.example.services.implementations;

import javafx.util.Pair;
import org.example.models.CustomPair;
import org.example.models.FoodItem;
import org.example.models.Order;
import org.example.models.Restaurant;
import org.example.services.FoodWiseRestaurantRatingService;
import org.example.services.interfaces.Observer;

import java.util.*;

class CustomComparator2 implements Comparator<CustomPair> {

    @Override
    public int compare(CustomPair o1, CustomPair o2) {
        if (Objects.isNull(o2.getRating()) && Objects.isNull(o1.getRating())) {
            return o1.getRestaurant().getName().compareTo(o2.getRestaurant().getName());
        }
        if (Objects.isNull(o2.getRating())) {
            return -1;
        }
        if (Objects.isNull(o1.getRating())) {
            return 1;
        }
        if (Objects.equals(o2.getRating(), o1.getRating())) {
            return o1.getRestaurant().getName().compareTo(o2.getRestaurant().getName());
        }
        return Double.compare(o2.getRating(), o1.getRating());
    }
}

public class FoodWiseRestaurantRatingServiceImpl implements FoodWiseRestaurantRatingService, Observer {

    private final Map<FoodItem, Set<CustomPair>> restaurantRankingBasedOnFoodItems;

    public FoodWiseRestaurantRatingServiceImpl(List<FoodItem> foodItems, List<Restaurant> restaurants) {
        restaurantRankingBasedOnFoodItems = new HashMap<>();
        for (FoodItem foodItem : foodItems) {
            Set<CustomPair> newSet = new TreeSet<>(new CustomComparator2());
            for (Restaurant restaurant : restaurants) {
                CustomPair customPair = new CustomPair(null, restaurant);
                newSet.add(customPair);
            }
            this.restaurantRankingBasedOnFoodItems.put(foodItem, newSet);
        }
    }

    @Override
    public void update(Pair<Order, Double> o) {
        Restaurant restaurant = o.getKey().getRestaurant();
        FoodItem foodItem = o.getKey().getFoodItem();
        Double rating = o.getValue();
        Set<CustomPair> sortedSetForFoodItem = this.restaurantRankingBasedOnFoodItems.get(foodItem);
        CustomPair newPair = new CustomPair(rating, restaurant);
        boolean removalResult = sortedSetForFoodItem.remove(new CustomPair(null, restaurant));
        System.out.println("element removed from set for food item : " + removalResult);
        sortedSetForFoodItem.add(newPair);
    }

    @Override
    public List<Restaurant> getTopRestaurantsForFoodItem(FoodItem foodItem) {
        return this.restaurantRankingBasedOnFoodItems.get(foodItem).stream().map(CustomPair::getRestaurant).toList();
    }
}
