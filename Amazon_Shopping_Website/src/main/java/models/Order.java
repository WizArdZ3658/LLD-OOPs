package models;

import enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Order {
    private Integer id;
    private List<Product> productsBought;
    private OrderStatus status;
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "productsBought=" + productsBought +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
