package model;

import components.HouseKeepingRecord;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private Integer roomId;
    private Integer costPerNight;
    private RoomStatus roomStatus;
    private RoomType roomType;
    private List<HouseKeepingRecord> houseKeepingRecords = new ArrayList<>();
}
