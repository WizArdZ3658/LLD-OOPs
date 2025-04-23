package service.implementations;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;
import model.enums.PaymentMethod;
import model.enums.SlotStatus;
import service.ParkingLotService;
import service.interfaces.PaymentService;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLot parkingLot;
    private final Map<String, Slot> carSlotMap;

    public ParkingLotServiceImpl(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.carSlotMap = new HashMap<>();
    }

    @Override
    public Ticket checkIn(Car car) {
        List<Slot> slots = parkingLot.getSlots();
        Slot slot = slots.stream().filter(slot1 -> slot1.getStatus() == SlotStatus.VACANT).toList().get(0);
        Ticket ticket = new Ticket(new Date(), null, car, slot);
        slot.setStatus(SlotStatus.OCCUPIED);
        this.carSlotMap.put(car.getRegistrationNumber(), slot);
        return ticket;
    }

    @Override
    public Boolean checkOut(Ticket ticket) {
        Slot slot = ticket.getSlot();
        slot.setStatus(SlotStatus.VACANT);
        this.carSlotMap.remove(ticket.getCar().getRegistrationNumber());
        return null;
    }

    @Override
    public Slot searchCar(String registrationNumber) {
        if (this.carSlotMap.containsKey(registrationNumber)) {
            return this.carSlotMap.get(registrationNumber);
        }
        return null;
    }

    @Override
    public Bill generateBill(Ticket ticket) {
        return null;
    }

    @Override
    public Boolean collectPayment(Bill bill, PaymentMethod paymentMethod) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PaymentService paymentService = PaymentMethodFactory.getPaymentService(paymentMethod);
        paymentService.getPayment(bill.getAmount());
        return true;
    }
}
