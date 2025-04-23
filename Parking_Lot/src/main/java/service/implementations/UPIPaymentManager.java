package service.implementations;

import lombok.AllArgsConstructor;
import service.interfaces.PaymentService;

@AllArgsConstructor
public class UPIPaymentManager implements PaymentService {

    @Override
    public Boolean getPayment(Double amount) {
        return true;
    }
}
