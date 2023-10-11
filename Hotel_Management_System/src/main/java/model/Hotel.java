package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
    private String name;
    private Integer hotelId;
    private List<Room> rooms = new ArrayList<>();
}
