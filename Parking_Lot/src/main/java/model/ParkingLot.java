package model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
    private List<Slot> slots;
}
