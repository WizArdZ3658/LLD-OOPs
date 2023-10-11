package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cab {
    private String numberPlate;
    private String color;
    private String model;
    private Driver driver;
    private CabStatus cabStatus;
    private Location location;
}
