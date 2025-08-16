package org.example.services.implementations;

import org.example.enums.SeatStatus;
import org.example.exceptions.SeatNotAvailableException;
import org.example.models.*;
import org.example.services.BookingService;
import org.example.utils.DateUtils;

import java.util.*;

public class BookingServiceImpl implements BookingService {

    private final Map<String, List<Trip>> tripsMap = new HashMap<>();

    @Override
    public List<Bus> listBuses(City from, City to, Date journeyDate) {
        String key = DateUtils.getFormattedDate(journeyDate);
        List<Bus> result = new ArrayList<>();
        for (Trip trip : this.tripsMap.get(key)) {
            if (trip.getCityToCityMap().containsKey(from) && trip.getCityToCityMap().get(from).contains(to)) {
                System.out.println("This trip contains source and destination : " + trip);
                result.add(trip.getBus());
            }
        }
        return result;
    }

    @Override
    public void bookBus(City from, City to, Integer numberOfSeats, Trip trip) throws SeatNotAvailableException {
        List<Segment> tripSegments = trip.getSegments();
        List<Segment> filteredSegment = new ArrayList<>();
        boolean startProcessing = false;
        for (int i = 0; i < tripSegments.size(); i++) {
            Segment segment = tripSegments.get(i);
            if (Objects.equals(segment.getFrom(), from)) {
                startProcessing = true;
            }

            if (startProcessing) {
                long availableSeats = segment
                        .getSegmentSeats()
                        .stream()
                        .filter(tripSegmentSeat -> Objects.equals(tripSegmentSeat.getStatus(), SeatStatus.VACANT))
                        .count();
                System.out.println(availableSeats + " seats available for " + segment);
                if (availableSeats >= numberOfSeats) {
                    filteredSegment.add(segment);
                } else {
                    throw new SeatNotAvailableException("only " + availableSeats + " is/are available");
                }
            }

            if (Objects.equals(segment.getTo(), to)) {
                startProcessing = false;
            }
        }

        for (Segment segment : filteredSegment) {
            int count = numberOfSeats;
            for (TripSegmentSeat seat : segment.getSegmentSeats()) {
                if (Objects.equals(seat.getStatus(), SeatStatus.VACANT)) {
                    count--;
                    seat.setStatus(SeatStatus.OCCUPIED);
                }
                if (count == 0) {
                    break;
                }
            }
        }


    }

    @Override
    public void registerTrip(Trip trip) {
        List<Trip> trips = this.tripsMap.getOrDefault(DateUtils.getFormattedDate(trip.getStartTime()), new ArrayList<>());
        trips.add(trip);
        this.tripsMap.put(DateUtils.getFormattedDate(trip.getStartTime()), trips);
    }
}
