package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Segment {
    private City from;
    private City to;
    List<TripSegmentSeat> segmentSeats;

    @Override
    public String toString() {
        return "Segment{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
