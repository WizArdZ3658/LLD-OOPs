package model;

import enums.SeatStatus;
import enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private String seatId;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private Double price;
}

