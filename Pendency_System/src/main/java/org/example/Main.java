package org.example;

import org.example.implementations.PendencySystemImpl;
import org.example.interfaces.PendencySystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pendency System");
        PendencySystem pendencySystem = new PendencySystemImpl();
        pendencySystem.startTracking(1112, new ArrayList<>(Arrays.asList("UPI", "Karnataka", "Bangalore")));
        pendencySystem.startTracking(2451,new ArrayList<>(Arrays.asList("UPI", "Karnataka", "Mysore")));
        pendencySystem.startTracking(3421,new ArrayList<>(Arrays.asList("UPI", "Rajasthan", "Jaipur")));
        pendencySystem.startTracking(1221,new ArrayList<>(Arrays.asList("Wallet", "Karnataka", "Bangalore")));

        System.out.println(pendencySystem.getCounts(new ArrayList<>(List.of("UPI"))));
        System.out.println(pendencySystem.getCounts(new ArrayList<>(Arrays.asList("UPI", "Karnataka"))));
        System.out.println(pendencySystem.getCounts(new ArrayList<>(Arrays.asList("UPI", "Karnataka", "Bangalore"))));
        System.out.println(pendencySystem.getCounts(new ArrayList<>(List.of("Bangalore"))));

        pendencySystem.startTracking(4221, new ArrayList<>(Arrays.asList("Wallet", "Karnataka", "Bangalore")));

        pendencySystem.stopTracking(1112);
        pendencySystem.stopTracking(2451);

        System.out.println(pendencySystem.getCounts(new ArrayList<>(List.of("UPI"))));
        System.out.println(pendencySystem.getCounts(new ArrayList<>(List.of("Wallet"))));
        System.out.println(pendencySystem.getCounts(new ArrayList<>(Arrays.asList("UPI", "Karnataka", "Bangalore"))));
    }
}