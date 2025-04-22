package org.example.services.implementations;

import javafx.util.Pair;
import org.example.enums.OrderStatus;
import org.example.models.FoodItem;
import org.example.models.Order;
import org.example.models.Restaurant;
import org.example.services.FoodOrderingService;
import org.example.services.FoodWiseRestaurantRatingService;
import org.example.services.RestaurantRatingService;
import org.example.services.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FoodOrderingServiceImpl implements FoodOrderingService, Observable {

    private static Integer orderCount = 0;
    private final List<Observer> channels;
    private final RestaurantRatingService restaurantRatingService;
    private final FoodWiseRestaurantRatingService foodWiseRestaurantRatingService;

    public FoodOrderingServiceImpl(RestaurantRatingService restaurantRatingService, FoodWiseRestaurantRatingService foodWiseRestaurantRatingService) {
        this.channels = new ArrayList<>();
        this.restaurantRatingService = restaurantRatingService;
        this.foodWiseRestaurantRatingService = foodWiseRestaurantRatingService;
        this.channels.add((Observer) restaurantRatingService);
        this.channels.add((Observer) foodWiseRestaurantRatingService);
    }

    @Override
    public Order orderFood(Restaurant restaurant, FoodItem foodItem) {
        Order order = new Order();
        order.setId(orderCount++);
        order.setOrderStatus(OrderStatus.PLACED);
        order.setFoodItem(foodItem);
        order.setRestaurant(restaurant);
        return order;
    }

    @Override
    public void rateOrder(Order order, Double rating) {
        Restaurant restaurant = order.getRestaurant();
        FoodItem foodItem = order.getFoodItem();
        Double newRestaurantRating = (((restaurant.getRating() * restaurant.getTotalRatingsReceived()) + rating) / (restaurant.getTotalRatingsReceived() + 1));
//        System.out.println("new restaurant rating : " + newRestaurantRating);
        restaurant.setRating(newRestaurantRating);
        restaurant.setTotalRatingsReceived(restaurant.getTotalRatingsReceived() + 1);
        List<Pair<FoodItem, Double>> foodItems = new ArrayList<>();
        for (Pair<FoodItem, Double> foodItemRating : restaurant.getFoodItems()) {
            if (Objects.equals(foodItemRating.getKey(), foodItem)) {
                foodItems.add(new Pair<>(foodItem, rating));
                continue;
            }
            foodItems.add(foodItemRating);
        }
//        System.out.println("new food items list for restaurant : " + foodItems);
        restaurant.setFoodItems(foodItems);
        this.notifyChannels(order, rating);
    }

    @Override
    public List<Restaurant> getTopRestaurantsByFood(FoodItem foodItem) {
        return this.foodWiseRestaurantRatingService.getTopRestaurantsForFoodItem(foodItem);
    }

    @Override
    public List<Restaurant> getTopRatedRestaurants() {
        return this.restaurantRatingService.getTopRestaurants();
    }

    @Override
    public void notifyChannels(Order order, Double rating) {
        for (Observer observer: this.channels) {
            System.out.println("sending updates");
            observer.update(new Pair<>(order, rating));
        }
    }

    @Override
    public void addChannel(Observer observer) {
        this.channels.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.channels.remove(observer);
    }
}
