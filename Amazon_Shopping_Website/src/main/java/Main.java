import models.Customer;
import models.Product;
import services.ConsumerService;
import services.SupplyService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SupplyService supplyService = new SupplyService();
        Product p1 = new Product("biscuits", 1);
        Product p2 = new Product("rice", 2);
        Product p3 = new Product("coffee", 3);
        supplyService.getProducts().add(p1);
        supplyService.getProducts().add(p2);
        supplyService.getProducts().add(p3);
        System.out.println(supplyService.listProduct());
        ConsumerService consumerService = new ConsumerService();
        Customer c1 = new Customer(1, "John");
        Customer c2 = new Customer(2, "Maya");
        Customer c3 = new Customer(3, "Tim");
        consumerService.placeOrder(c1, Arrays.asList(p1, p2));
        consumerService.placeOrder(c2, Arrays.asList(p2, p3));
        System.out.println(c1);
        System.out.println(c2);
    }
}

/*

Requirements
2) listing product (as a seller)
3) create customer
4) see products
5) buy product
6) add rating for a product
7) create order

 */
