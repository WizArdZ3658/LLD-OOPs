package org.example;

import org.example.models.Graph;
import org.example.models.Group;
import org.example.models.User;
import org.example.services.SplitWiseService;
import org.example.services.SplitWiseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Somnath");
        User user2 = new User(2, "Piyush");
        User user3 = new User(3, "Akshit");
        User user4 = new User(4, "Aakriti");
        Group g1 = new Group(1, "Saturday Outing", new ArrayList<>(List.of(user1, user2, user3, user4)));
        SplitWiseService splitWiseService = new SplitWiseServiceImpl();
        splitWiseService.addExpense(g1, user1, 100.0F, "burger");
        System.out.println(g1.getExpenses());
        System.out.println(splitWiseService.getGroupPaymentGraph(g1));
        System.out.println();
        splitWiseService.addExpense(g1, user3, 40.0F, "pizza");
        System.out.println(g1.getExpenses());
        System.out.println(splitWiseService.getGroupPaymentGraph(g1));
        System.out.println();
        splitWiseService.addExpense(g1, user2, 4000.0F, "games");
        System.out.println(g1.getExpenses());
        System.out.println(splitWiseService.getGroupPaymentGraph(g1));
        System.out.println();
        splitWiseService.settleExpenses(g1);

        System.out.println(g1.getTotalBalanceOfUsers());
    }
}

/*

This is a common machine coding question and has been asked in many companies like OpenTable, ShareChat, ClearTax, Groww etc.

Features including group expenses and partial split of expenses are expected in the solution.

https://medium.com/@prashant558908/solving-top-10-low-level-design-lld-interview-questions-in-2024-302b6177c869

 */