package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Bus {
    private Integer id;
    private String registrationNumber;
    private Operator operator;
    private List<Seat> seats;

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", operator=" + operator +
                '}';
    }
}
