package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.SlotStatus;

@Getter
@Setter
public class Slot {
    private String slotNumber;
    private Integer floorNumber;
    private SlotStatus status;
}
