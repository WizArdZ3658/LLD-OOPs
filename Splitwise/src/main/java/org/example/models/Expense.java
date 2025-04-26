package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Expense {
    private Float amount;
    private User paidBy;
    private String description;

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", paidBy=" + paidBy +
                ", description='" + description + '\'' +
                '}';
    }
}
