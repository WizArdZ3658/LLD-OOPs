package model;

import enums.BookingStatus;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
    private String id;
    private Show show;
    private Date bookingDate;
    private Customer customer;
    private Audi audi;
    private Integer amount;
    private BookingStatus bookingStatus;
    private List<Seat> seats;
}
