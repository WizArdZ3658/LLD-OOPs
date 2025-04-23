package service.implementations;

import lombok.AllArgsConstructor;
import service.interfaces.PaymentService;

@AllArgsConstructor
public class CardPaymentManager implements PaymentService {

    /*
    can use adapter here for integration with VISA or MasterCard
     */

    @Override
    public Boolean getPayment(Double amount) {
        if (this.validatePayment(amount)) {
            return this.triggerTransaction(amount);
        }
        return true;
    }

    private Boolean validatePayment(Double amount) {
        return true;
    }

    private Boolean triggerTransaction(Double amount) {
        return true;
    }
}
