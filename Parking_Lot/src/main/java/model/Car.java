package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String model;
    private String colour;
    private String registrationNumber;
    private User user;
}
