package service.implementations;


import model.Bill;
import model.Car;
import model.Ticket;
import service.interfaces.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public Car searchCar(String colour, String registrationNumber, String model) {
        return null;
    }

    @Override
    public Bill generateBill(Ticket ticket) {
        return null;
    }

    @Override
    public Boolean collectPayment(Bill bill) {
        return null;
    }
}
