package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trip {
    private Location source;
    private Location destination;
    private Double amount;
    private User user;
    private Cab cab;
    private TripStatus tripStatus;
}
