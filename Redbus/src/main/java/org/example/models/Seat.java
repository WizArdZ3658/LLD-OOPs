package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seat {
    private Integer id;
    private Integer rowNumber;

    @Override
    public String toString() {
        return id.toString();
    }
}
