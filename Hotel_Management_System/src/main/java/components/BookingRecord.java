package components;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRecord {
    private Integer roomId;
    private String emailId;
    private Date startDate;
    private Integer durationInNights;
}
