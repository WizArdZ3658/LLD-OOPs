package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer extends User {
    private String address;
    private List<Order> orders;

    public Customer(Integer id, String name) {
        super(name, id);
        this.orders = new ArrayList<>();
    }

    public void notifyCustomer(Order order) {
        System.out.println(this.getName() + " is notified about state change in status : " + order.getStatus());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + this.getName() + '\'' +
                ", orders=" + orders +
                '}';
    }
}
