package operations;

import components.BookingRecord;
import model.Room;

public class BillGenerationHandler {

    public void generateBill(Room room, BookingRecord bookingRecord) {
        processPayment(room.getCostPerNight() * bookingRecord.getDurationInNights());
    }

    public void processPayment(Integer amount) {
        System.out.println("Processed payment with amount : " + amount);
    }
}
