package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import operations.BookingHandler;

@Getter
@Setter
@ToString
public class Customer extends Person {

    private BookingHandler bookingHandler = new BookingHandler();
}
