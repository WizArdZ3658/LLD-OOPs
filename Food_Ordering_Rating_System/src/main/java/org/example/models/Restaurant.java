package org.example.models;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Restaurant {
    private Integer id;
    private String name;
    private List<Pair<FoodItem, Double>> foodItems;
    private Integer totalRatingsReceived;
    private Double rating;

    public Restaurant(Integer id, String name, List<Pair<FoodItem, Double>> foodItems) {
        this.id = id;
        this.name = name;
        this.foodItems = foodItems;
        this.totalRatingsReceived = 0;
        this.rating = 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", foodItems=" + foodItems +
                ", totalRatingsReceived=" + totalRatingsReceived +
                ", rating=" + rating +
                '}';
    }
}
