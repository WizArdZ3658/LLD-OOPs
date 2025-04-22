package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CustomPair {
    private Double rating;
    private Restaurant restaurant;

    public CustomPair(Double rating, Restaurant restaurant) {
        this.rating = rating;
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomPair that = (CustomPair) o;
        return Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(restaurant);
    }
}
