package service.interfaces;

import model.Car;
import model.Ticket;

public interface UserService {
    Ticket checkIn(Car car);
    Boolean checkOut();
}
