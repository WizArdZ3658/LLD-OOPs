package model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private Date entryTime;
    private Date exitTime;
    private Car car;
    private Slot slot;
}
