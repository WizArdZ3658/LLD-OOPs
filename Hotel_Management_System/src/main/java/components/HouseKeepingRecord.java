package components;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import model.HouseKeeper;

@Getter
@Setter
public class HouseKeepingRecord {
    private String description;
    private HouseKeeper houseKeeper;
    private Date date;

}
