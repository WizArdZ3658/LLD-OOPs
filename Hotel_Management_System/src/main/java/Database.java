import components.BookingRecord;
import model.FoodItem;
import components.HouseKeepingRecord;
import model.Room;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import model.Admin;
import model.Customer;
import model.HouseKeeper;
import model.Receptionist;

@Getter
@Setter
public class Database {
    public static final List<Admin> admins = new ArrayList<>();
    public static final List<Customer> customers = new ArrayList<>();
    public static final List<HouseKeeper> houseKeepers = new ArrayList<>();
    public static final List<Receptionist> receptionists = new ArrayList<>();

    public static final List<Room> rooms = new ArrayList<>();
    public static final List<FoodItem> foodItems = new ArrayList<>();

    public static final List<BookingRecord> bookingRecords = new ArrayList<>();
    public static final List<HouseKeepingRecord> houseKeepingRecords = new ArrayList<>();

    static {

    }
}
