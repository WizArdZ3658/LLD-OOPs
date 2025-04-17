package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private String name;
    private Integer id;

    public User (String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
