package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show {
    private String showId;
    private String showName;
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private List<Seat> seatList = new ArrayList<>();
}
