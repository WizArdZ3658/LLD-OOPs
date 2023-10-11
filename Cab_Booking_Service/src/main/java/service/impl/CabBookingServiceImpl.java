package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Cab;
import model.CabStatus;
import model.Location;
import model.PaymentMode;
import model.Trip;
import model.TripStatus;
import model.User;
import service.factories.PaymentMethodFactory;
import service.interfaces.CabBookingService;
import service.interfaces.CabPricingService;
import service.interfaces.PaymentService;

public class CabBookingServiceImpl implements CabBookingService {
    private static final Double MAX_DISTANCE = Double.valueOf(10);

    CabPricingService cabPricingService;

    public CabBookingServiceImpl(CabPricingService cabPricingService) {
        this.cabPricingService = cabPricingService;
    }

    @Override
    public List<Cab> getAllCabs(Location location) {
        List<Cab> cabs = new ArrayList<>();
        return cabs.stream().filter(cab -> Math.sqrt(
            (location.getX() - cab.getLocation().getX()) * (location.getX() - cab.getLocation().getX())
            + (location.getY() - cab.getLocation().getY()) * (location.getY() - cab.getLocation().getY())
        ) < MAX_DISTANCE && cab.getCabStatus() == CabStatus.ACTIVE).collect(Collectors.toList());
    }

    @Override
    public Trip bookCab(User user, Location destination) {
        List<Cab> cabs = getAllCabs(user.getLocation());
        Cab cab = cabs.get(0);
        Trip trip = new Trip(user.getLocation(), destination, cabPricingService.getAmount(user.getLocation(), destination), user, cab, TripStatus.NOT_STARTED);
        cab.setCabStatus(CabStatus.OCCUPIED);
        return trip;
    }

    @Override
    public void cancelTrip(Trip trip) {
        trip.setTripStatus(TripStatus.CANCELLED);
        Cab cab = trip.getCab();
        cab.setCabStatus(CabStatus.ACTIVE);
    }

    @Override
    public void payCab(Trip trip, PaymentMode paymentMode) {
        PaymentService paymentService = PaymentMethodFactory.getPaymentService(paymentMode);
        paymentService.validatePayment();
        paymentService.initiatePayment();
    }
}
