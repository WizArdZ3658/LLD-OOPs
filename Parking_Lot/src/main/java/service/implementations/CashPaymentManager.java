package service.implementations;

import lombok.AllArgsConstructor;
import service.interfaces.PaymentService;

@AllArgsConstructor
public class CashPaymentManager implements PaymentService {

    @Override
    public Boolean getPayment(Double amount) {
        return true;
    }
}
