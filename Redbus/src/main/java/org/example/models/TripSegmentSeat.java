package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatStatus;

@Getter
@Setter
@AllArgsConstructor
public class TripSegmentSeat {
    private Seat seat;
    private SeatStatus status;

    @Override
    public String toString() {
        return "TripSegmentSeat{" +
                "seat=" + seat +
                ", status=" + status +
                '}';
    }
}
