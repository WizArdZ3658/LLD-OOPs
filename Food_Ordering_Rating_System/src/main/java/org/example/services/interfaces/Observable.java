package org.example.services.interfaces;

import org.example.models.Order;

public interface Observable {
    void notifyChannels(Order order, Double rating);
    void addChannel(Observer observer);
    void remove(Observer observer);
}
