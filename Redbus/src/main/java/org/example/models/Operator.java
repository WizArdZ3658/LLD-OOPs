package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Operator {
    private Integer id;
    private String name;
    private String contactNumber;

    @Override
    public String toString() {
        return name;
    }
}
