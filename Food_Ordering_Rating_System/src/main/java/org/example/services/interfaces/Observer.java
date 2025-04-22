package org.example.services.interfaces;

import javafx.util.Pair;
import org.example.models.Order;

public interface Observer {
    void update(Pair<Order, Double> o);
}
