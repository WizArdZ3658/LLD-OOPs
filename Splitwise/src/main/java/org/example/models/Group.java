package org.example.models;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Group {
    private Integer id;
    private String name;
    private List<User> users;
    private Double totalExpense;
    private Map<User, Double> totalBalanceOfUsers;
    private List<Expense> expenses;

    public Group(Integer id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.expenses = new ArrayList<>();
        this.totalBalanceOfUsers = new HashMap<>();
        for (User user : users) {
            totalBalanceOfUsers.put(user, 0.0);
        }
        this.totalExpense = 0.0;
    }
}
