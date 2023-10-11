package service.impl;

import model.Location;
import service.interfaces.CabPricingService;

public class DistanceBasedCabPricing implements CabPricingService {

    @Override
    public Double getAmount(Location source, Location destination) {
        return 50.0;
    }
}
