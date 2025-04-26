package org.example.services;

import javafx.util.Pair;
import org.example.models.Expense;
import org.example.models.Graph;
import org.example.models.Group;
import org.example.models.User;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class CustomComparatorForMinHeap implements Comparator<Pair<Double, User>> {

    @Override
    public int compare(Pair<Double, User> o1, Pair<Double, User> o2) {
        return Double.compare(o1.getKey(), o2.getKey());
    }
}


class CustomComparatorForMaxHeap implements Comparator<Pair<Double, User>> {

    @Override
    public int compare(Pair<Double, User> o1, Pair<Double, User> o2) {
        return Double.compare(o2.getKey(), o1.getKey());
    }
}

public class SplitWiseServiceImpl implements SplitWiseService {

    public Graph getGroupPaymentGraph(Group group) {
        Map<User, Double> totalBalanceOfUsersMap = group.getTotalBalanceOfUsers();
        Graph g = new Graph(totalBalanceOfUsersMap.size());
        PriorityQueue<Pair<Double, User>> minHeap = new PriorityQueue<>(new CustomComparatorForMinHeap());
        PriorityQueue<Pair<Double, User>> maxHeap = new PriorityQueue<>(new CustomComparatorForMaxHeap());
        for (User user : totalBalanceOfUsersMap.keySet()) {
            Double amount = totalBalanceOfUsersMap.get(user);
            if (amount < 0) {
                minHeap.add(new Pair<>(amount, user));
            } else if (amount > 0) {
                maxHeap.add(new Pair<>(amount, user));
            }
        }
        while (!minHeap.isEmpty()) {
            Pair<Double, User> minHeapPair = minHeap.poll();
            Pair<Double, User> maxHeapPair = maxHeap.poll();
            Double resultant = minHeapPair.getKey() + maxHeapPair.getKey();
            g.addEdge(
                    maxHeapPair.getValue(),
                    minHeapPair.getValue(),
                    Math.min(maxHeapPair.getKey(), -minHeapPair.getKey())
            );
            if (resultant > 0) {
                maxHeap.add(new Pair<>(resultant, maxHeapPair.getValue()));
            } else if (resultant < 0) {
                minHeap.add(new Pair<>(resultant, minHeapPair.getValue()));
            }
        }
        return g;
    }

    @Override
    public void addExpense(Group group, User paidBy, Float amount, String description) {
        Expense expense = new Expense(amount, paidBy, description);
        Float expensePerPerson = amount/group.getUsers().size();
        for (User user : group.getUsers()) {
            if (group.getTotalBalanceOfUsers().containsKey(user)) {
                if (Objects.equals(user, paidBy)) {
                    group.getTotalBalanceOfUsers().put(user, group.getTotalBalanceOfUsers().get(user) - (amount - expensePerPerson));
                } else {
                    group.getTotalBalanceOfUsers().put(user, group.getTotalBalanceOfUsers().get(user) + expensePerPerson);
                }
            }
        }
        group.getExpenses().add(expense);
        group.setTotalExpense(group.getTotalExpense() + amount);
    }

    @Override
    public Expense editExpense(Expense e, Float amount, String description) {
        return null;
    }

    @Override
    public void settleExpenses(Group group) {
        PriorityQueue<Pair<Double, User>> minHeap = new PriorityQueue<>(new CustomComparatorForMinHeap());
        PriorityQueue<Pair<Double, User>> maxHeap = new PriorityQueue<>(new CustomComparatorForMaxHeap());
        for (User user : group.getTotalBalanceOfUsers().keySet()) {
            Double amount = group.getTotalBalanceOfUsers().get(user);
            if (amount < 0) {
                minHeap.add(new Pair<>(amount, user));
            } else if (amount > 0) {
                maxHeap.add(new Pair<>(amount, user));
            }
        }
        while (!minHeap.isEmpty()) {
//            System.out.println(maxHeap + " XXX " + minHeap);
            Pair<Double, User> minHeapPair = minHeap.poll();
            Pair<Double, User> maxHeapPair = maxHeap.poll();
            double resultant = minHeapPair.getKey() + maxHeapPair.getKey();
            if (resultant > 0) {
                System.out.println(maxHeapPair.getValue() + " pays " + minHeapPair.getValue() + " INR " + -minHeapPair.getKey());
                maxHeap.add(new Pair<>(resultant, maxHeapPair.getValue()));
            } else if (resultant < 0) {
                System.out.println(maxHeapPair.getValue() + " pays " + minHeapPair.getValue() + " INR " + maxHeapPair.getKey());
                minHeap.add(new Pair<>(resultant, minHeapPair.getValue()));
            } else {
                System.out.println(maxHeapPair.getValue() + " pays " + minHeapPair.getValue() + " INR " + maxHeapPair.getKey());
            }
        }
        for (User user : group.getTotalBalanceOfUsers().keySet()) {
            group.getTotalBalanceOfUsers().put(user, 0.0);
        }
        System.out.println("Settlement done");
    }
}
