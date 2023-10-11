package service.interfaces;

import model.Location;

public interface CabPricingService {
    Double getAmount(Location source, Location destination);
}
