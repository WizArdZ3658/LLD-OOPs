package service.interfaces;

import model.CabStatus;
import model.Trip;

public interface CabDriverService {
    Boolean setCabAvailabilityStatus(CabStatus cabStatus);
    Boolean startTrip(Trip trip);
    Boolean completeTrip(Trip trip);
}
