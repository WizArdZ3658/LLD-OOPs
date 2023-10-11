package service.impl;

import model.Cab;
import model.CabStatus;
import model.Trip;
import model.TripStatus;
import service.interfaces.CabDriverService;

public class CabDriverServiceImpl implements CabDriverService {

    @Override
    public Boolean setCabAvailabilityStatus(CabStatus cabStatus) {
        return null;
    }

    @Override
    public Boolean startTrip(Trip trip) {
        trip.setTripStatus(TripStatus.STARTED);
        return true;
    }

    @Override
    public Boolean completeTrip(Trip trip) {
        trip.setTripStatus(TripStatus.COMPLETED);
        Cab cab = trip.getCab();
        cab.setCabStatus(CabStatus.ACTIVE);
        return true;
    }
}
