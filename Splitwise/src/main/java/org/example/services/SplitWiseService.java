package org.example.services;

import org.example.models.Expense;
import org.example.models.Graph;
import org.example.models.Group;
import org.example.models.User;

public interface SplitWiseService {
    Graph getGroupPaymentGraph(Group group);
    void addExpense(Group group, User paidBy, Float amount, String description);
    Expense editExpense(Expense e, Float amount, String description);
    void settleExpenses(Group group);
}
