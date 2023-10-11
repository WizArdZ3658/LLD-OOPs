package service.factories;

import java.util.HashMap;
import java.util.Map;
import model.PaymentMode;
import service.impl.payment.CardPaymentManager;
import service.impl.payment.CashPaymentManager;
import service.impl.payment.UPIPaymentManager;
import service.interfaces.PaymentService;

public class PaymentMethodFactory {
    private static final Map<PaymentMode, PaymentService> registry = new HashMap<>();

    static {
        registry.put(PaymentMode.CASH, new CashPaymentManager());
        registry.put(PaymentMode.CARD, new CardPaymentManager());
        registry.put(PaymentMode.UPI, new UPIPaymentManager());
    }

    public static PaymentService getPaymentService(PaymentMode paymentMode) {
        return registry.get(paymentMode);
    }
}
