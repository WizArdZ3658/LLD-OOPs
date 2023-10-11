package service.interfaces;

import model.Bill;
import model.Car;
import model.Ticket;

public interface AdminService {
    Car searchCar(String colour, String registrationNumber, String model);
    Bill generateBill(Ticket ticket);

    Boolean collectPayment(Bill bill);
}
