package services;

import enums.OrderStatus;
import models.Customer;
import models.Inventory;
import models.Order;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ConsumerService {

    private static Integer orderIdCounter = 0;
    private Inventory inventory;
    private List<Order> orders = new ArrayList<>();

    public ConsumerService() {
    }

    public void addProductRating(Product product, Integer rating) {
        product.setRating(rating);
    }

    public Order placeOrder(Customer customer, List<Product> products) {
        Order order = new Order();
        order.setProductsBought(products);
        order.setStatus(OrderStatus.PLACED);
        order.setId(orderIdCounter);
        order.setCustomer(customer);
        orderIdCounter++;
        customer.getOrders().add(order);
        orders.add(order);
        return order;
    }

    public void changeOrderStatus(Order order, OrderStatus newStatus) {
        order.setStatus(newStatus);
        order.getCustomer().notifyCustomer(order);
    }
}
