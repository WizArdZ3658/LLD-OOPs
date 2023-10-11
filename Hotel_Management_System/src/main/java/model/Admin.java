package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import operations.BookingHandler;
import operations.RoomOpHandler;

@Getter
@Setter
@ToString
public class Admin extends Person {

    private BookingHandler bookingHandler = new BookingHandler();
    private RoomOpHandler roomOpHandler = new RoomOpHandler();
}
