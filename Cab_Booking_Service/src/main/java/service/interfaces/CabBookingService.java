package service.interfaces;

import java.util.List;
import model.Cab;
import model.Location;
import model.PaymentMode;
import model.Trip;
import model.User;

public interface CabBookingService {
    List<Cab> getAllCabs(Location location);
    Trip bookCab(User user, Location destination);
    void cancelTrip(Trip trip);

    void payCab(Trip trip, PaymentMode paymentMode);
}
