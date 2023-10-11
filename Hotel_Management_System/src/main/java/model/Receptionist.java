package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import operations.BookingHandler;

@Getter
@Setter
@ToString
public class Receptionist extends Person {

    private BookingHandler bookingHandler = new BookingHandler();

    public void checkInCustomer() {

    }

    public void checkOutCustomer() {

    }
}
