package service.implementations;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.ParkingLot;
import model.Slot;
import model.Ticket;
import model.enums.SlotStatus;
import service.interfaces.UserService;

public class UserServiceImpl implements UserService {
    ParkingLot parkingLot;

    public UserServiceImpl(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public Ticket checkIn(Car car) {
        List<Slot> slots = parkingLot.getSlots();
        Slot slot = slots.stream().filter(slot1 -> slot1.getStatus() == SlotStatus.VACANT).collect(
            Collectors.toList()).get(0);
        Ticket ticket = new Ticket(new Date(), null, car, slot);
        slot.setStatus(SlotStatus.OCCUPIED);
        slot.setTicket(ticket);
        return ticket;
    }

    @Override
    public Boolean checkOut() {
        return null;
    }
}
