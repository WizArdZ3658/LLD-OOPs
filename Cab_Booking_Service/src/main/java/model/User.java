package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Person{
    private Location location;

    public User(String name, String phoneNo, String email, Location location) {
        super(name, phoneNo, email);
        this.location = location;
    }
}
