package org.example.services;

import org.example.exceptions.SeatNotAvailableException;
import org.example.models.Bus;
import org.example.models.City;
import org.example.models.Trip;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<Bus> listBuses(City from, City to, Date journeyDate);
    void bookBus(City from, City to, Integer numberOfSeats, Trip trip) throws SeatNotAvailableException;
    void registerTrip(Trip trip);
}
