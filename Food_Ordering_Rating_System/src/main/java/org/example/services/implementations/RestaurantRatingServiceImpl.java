package org.example.services.implementations;

import javafx.util.Pair;
import org.example.models.Order;
import org.example.models.Restaurant;
import org.example.services.interfaces.Observer;
import org.example.services.RestaurantRatingService;

import java.util.*;

class CustomComparator implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        if (Objects.equals(o2.getRating(), o1.getRating())) {
            return o1.getName().compareTo(o2.getName());
        }
        return Double.compare(o2.getRating(), o1.getRating());
    }
}

public class RestaurantRatingServiceImpl implements Observer, RestaurantRatingService {

    private final Set<Restaurant> orderedRestaurants;

    public RestaurantRatingServiceImpl(List<Restaurant> restaurants) {
        this.orderedRestaurants = new TreeSet<>(new CustomComparator());
        this.orderedRestaurants.addAll(restaurants);
    }

    @Override
    public void update(Pair<Order, Double> o) {
        Restaurant restaurant = o.getKey().getRestaurant();
        boolean removalResult = this.orderedRestaurants.remove(restaurant);
        System.out.println("element removed from set for food item : " + removalResult);
        orderedRestaurants.add(restaurant);
    }

    @Override
    public List<Restaurant> getTopRestaurants() {
        return this.orderedRestaurants.stream().toList();
    }
}
