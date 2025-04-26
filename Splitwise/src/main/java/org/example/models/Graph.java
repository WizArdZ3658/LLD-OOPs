package org.example.models;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<User, List<Pair<Double,User>>> adjacencyList;

    public Graph(Integer numberOfNodes) {
        this.adjacencyList = new HashMap<>();
    }

    public Boolean addEdge(User from, User to, Double amount) {
        if (!this.adjacencyList.containsKey(from)) {
            this.adjacencyList.put(from, new ArrayList<>());
        }
        this.adjacencyList.get(from).add(new Pair<>(amount, to));
        return true;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }
}
