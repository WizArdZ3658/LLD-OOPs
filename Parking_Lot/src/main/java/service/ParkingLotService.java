package service;

import model.Bill;
import model.Car;
import model.Slot;
import model.Ticket;
import model.enums.PaymentMethod;

import java.lang.reflect.InvocationTargetException;

public interface ParkingLotService {
    Ticket checkIn(Car car);
    Boolean checkOut(Ticket ticket);
    Slot searchCar(String registrationNumber);
    Bill generateBill(Ticket ticket);

    Boolean collectPayment(Bill bill, PaymentMethod paymentMethod) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
