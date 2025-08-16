package org.example;

import org.example.exceptions.SeatNotAvailableException;
import org.example.models.*;
import org.example.enums.*;
import org.example.services.BookingService;
import org.example.services.implementations.BookingServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SeatNotAvailableException {
        BookingService bookingService = new BookingServiceImpl();
        Operator operator1 = new Operator(1, "Typical White Bus Operator", "9911009949");
        List<Seat> seats = getSeats();
        Bus bus1 = new Bus(1, "HR38AP1990", operator1, seats);

        City city1 = new City(1, "Delhi");
        City city2 = new City(2, "Gurgaon");
        City city3 = new City(3, "Noida");
        City city4 = new City(4, "Faridabad");
        City city5 = new City(5, "Ghaziabad");
        List<City> cities1 = new ArrayList<>();
        cities1.add(city1);
        cities1.add(city2);
        cities1.add(city3);
        cities1.add(city4);
        cities1.add(city5);

        List<City> cities2 = new ArrayList<>();
        cities2.add(city5);
        cities2.add(city4);
        cities2.add(city3);
        cities2.add(city2);
        cities2.add(city1);

        Trip trip1 = new Trip(bus1, cities1, new Date());
        Trip trip2 = new Trip(bus1, cities2, new Date());
        Trip trip3 = new Trip(bus1, cities1, new Date());
        Trip trip4 = new Trip(bus1, cities2, new Date());
//        System.out.println(trip1);
//        System.out.println(trip2);

        bookingService.registerTrip(trip1);
        bookingService.registerTrip(trip2);
        bookingService.registerTrip(trip3);
        bookingService.registerTrip(trip4);

        System.out.println(bookingService.listBuses(city4, city1, new Date()));

        bookingService.bookBus(city4, city1, 5, trip2);
        bookingService.bookBus(city4, city1, 2, trip2);

//        List<Seat> seats2 = getSeats();
//        Bus bus2 = new Bus(1, "HR48MP1888", operator1, seats2);

    }

    private static List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        Seat seat1 = new Seat(1, 1);
        Seat seat2 = new Seat(2, 2);
        Seat seat3 = new Seat(3, 3);
        Seat seat4 = new Seat(4, 4);
        Seat seat5 = new Seat(5, 5);
        Seat seat6 = new Seat(6, 6);
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        seats.add(seat6);
        return seats;
    }
}

/*
https://medium.com/@nageswarnandyala4/lld-of-red-bus-irctc-6b5ee14874e5

Functional Requirements :-
1. Users should be able to list buses with available seats and number of stops from source to destination
2. Users should be able to book/cancel seats.
3. Buses can have multiple stops between source and destination
4. Show estimated time.
5. Notifications

Non-Functional Requirements :-
1. Handle isolation when multiple users are booking the same bus

 */