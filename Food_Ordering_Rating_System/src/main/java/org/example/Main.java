package org.example;

import javafx.util.Pair;
import org.example.models.FoodItem;
import org.example.models.Order;
import org.example.models.Restaurant;
import org.example.services.FoodOrderingService;
import org.example.services.FoodWiseRestaurantRatingService;
import org.example.services.RestaurantRatingService;
import org.example.services.implementations.FoodOrderingServiceImpl;
import org.example.services.implementations.FoodWiseRestaurantRatingServiceImpl;
import org.example.services.implementations.RestaurantRatingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoodItem foodItem1 = new FoodItem(1, "Burger");
        FoodItem foodItem2 = new FoodItem(2, "Pizza");
        FoodItem foodItem3 = new FoodItem(3, "French Fries");
        FoodItem foodItem4 = new FoodItem(4, "Chicken Popcorn");
        FoodItem foodItem5 = new FoodItem(5, "Cold Coffee");
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(foodItem1);
        foodItems.add(foodItem2);
        foodItems.add(foodItem3);
        foodItems.add(foodItem4);
        foodItems.add(foodItem5);

        List<Pair<FoodItem, Double>> foodItems1 = new ArrayList<>();
        foodItems1.add(new Pair<>(foodItem1, null));
        foodItems1.add(new Pair<>(foodItem3, null));
        foodItems1.add(new Pair<>(foodItem5, null));
        Restaurant restaurant1 = new Restaurant(1, "Cafe Delhi Heights", foodItems1);

        List<Pair<FoodItem, Double>> foodItems2 = new ArrayList<>();
        foodItems2.add(new Pair<>(foodItem1, null));
        foodItems2.add(new Pair<>(foodItem2, null));
        foodItems2.add(new Pair<>(foodItem3, null));
        Restaurant restaurant2 = new Restaurant(2, "Dominos", foodItems2);

        List<Pair<FoodItem, Double>> foodItems3 = new ArrayList<>();
        foodItems3.add(new Pair<>(foodItem3, null));
        foodItems3.add(new Pair<>(foodItem4, null));
        foodItems3.add(new Pair<>(foodItem5, null));
        Restaurant restaurant3 = new Restaurant(3, "Tim Hortons", foodItems3);

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);

        FoodWiseRestaurantRatingService foodWiseRestaurantRatingService = new FoodWiseRestaurantRatingServiceImpl(foodItems, restaurants);
        RestaurantRatingService restaurantRatingService = new RestaurantRatingServiceImpl(restaurants);
        FoodOrderingService foodOrderingService = new FoodOrderingServiceImpl(restaurantRatingService, foodWiseRestaurantRatingService);

        System.out.println(restaurant1);

        Order order1 = foodOrderingService.orderFood(restaurant1, foodItem1);
        Order order2 = foodOrderingService.orderFood(restaurant1, foodItem5);

        Order order3 = foodOrderingService.orderFood(restaurant2, foodItem2);

        Order order4 = foodOrderingService.orderFood(restaurant3, foodItem5);

        foodOrderingService.rateOrder(order1, 4.2);
        foodOrderingService.rateOrder(order2, 3.7);

        foodOrderingService.rateOrder(order3, 4.7);

        foodOrderingService.rateOrder(order4, 3.2);

        System.out.println(foodOrderingService.getTopRestaurantsByFood(foodItem5));

        System.out.println(foodOrderingService.getTopRatedRestaurants());
    }
}

/*

Problem statement and Machine coding practice link: https://codezym.com/question/5

For this question, core features will be:

Ordering food
Rating orders
Displaying list of restaurants based on rating, popularity etc.
List of restaurants can be displayed in multiple different ways like :

Top restaurants with highest average rating
Top restaurants with highest average rating for a particular food item.
These view classes will need to be need to updated whenever an order is rated by a user, so that they can update
their lists. Hence, this is an ideal use case of observer design pattern.


Method : init(Helper05 helper)
- Use this method to initialize your instance variables
- use helper's methods for printing logs else logs will not be visible.

Method : orderFood(String orderId, String restaurantId, String foodItemId)
- Orders food item from a restaurant.
- for now lets assume for that only a single food item is purchased in one order.
- orderId, restaurantId, foodItemId will all be valid and available.
- PARAMETER : restaurantId is restaurant from where food is being ordered.
- PARAMETER : foodItemId is food item which is being ordered

Method : rateOrder(String orderId, int rating)
- Customers can rate their order.
- when you are giving rating an order e.g giving 4 stars to an order, then it means you are assigning 4 stars to both
the food item in that restaurant as well as 4 stars to the overall restaurant rating.
- PARAMETER : orderId is order which will be rated by customer, orderId will always be valid i.e. order will always be
created for an orderId before rateOrder() is called.
- PARAMETER : rating ranges from 1 to 5 stars in increasing order, 1 being the worst and 5 being the best rating.

Method : List[String] getTopRestaurantsByFood(String foodItemId)
- Fetches a list of top 20 restaurants based on strategy
- unrated restaurants will be at the bottom of list.
- restaurants will be sorted on the basis of strategy
- restaurants are sorted in descending order on average ratings of the food item and then based on restaurant id lexicographically.
- e.g. veg burger is rated 4.3 in restaurant-4 and 4.6 in restaurant-6 then
we will return ['restaurant-6', 'restaurant-4']
- PARAMETER : foodItemId is food item for which restaurants need to be fetched.

Method : List[String] getTopRatedRestaurants()
- returns top 20 most rated restaurants ids sorted in descending order of their ratings.
- if two restaurants have the same rating then they will be ordered lexicographically by their restaurantId.
- Here we are talking about restaurant's overall rating and NOT food item's rating.
- e.g. restaurant-2 is rated 4.6 while restaurant-3 is rated 4.2 and restaurant-5 is rated 4.4 and restaurant-6 is rated 4.6,
we will return ['restaurant-2','restaurant-6', 'restaurant-5', 'restaurant-3']
- even though restaurant-2 and restaurant-6 have same rating , restaurant-6 came later because it is lexicographically greater than restaurant-2

Note :
- There will be at max 50 food items, at max 10,000 restaurants,
    and each restaurant can sell at max 25 food items
- Average ratings are rounded down to 1 decimal point,
    i.e. 4.05, 4.08, 4.11, 4.12, 4.14 all become 4.1
    and 4.15, 4.19, 4.22, 4.24 all become 4.2
- For Python, use round(rating, 1) function to round rating to 1 decimal point.
- For Java, use the formula (double)((int)((rating+0.05)*10))/10.0 to round rating


 */