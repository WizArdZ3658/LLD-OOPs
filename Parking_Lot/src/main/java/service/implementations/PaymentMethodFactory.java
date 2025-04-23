package service.implementations;

import model.Car;
import model.enums.PaymentMethod;
import service.interfaces.PaymentService;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PaymentMethodFactory {

    private static final Map<PaymentMethod, Class<? extends PaymentService>> registry = new HashMap<>();

    static {
        registry.put(PaymentMethod.CASH, CashPaymentManager.class);
        registry.put(PaymentMethod.CARD, CardPaymentManager.class);
        registry.put(PaymentMethod.UPI, UPIPaymentManager.class);
//        registry.put(PaymentMethod.TEST, (Class<? extends PaymentService>) Car.class);
    }

    public static PaymentService getPaymentService(PaymentMethod paymentMode) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return registry.get(paymentMode).getDeclaredConstructor().newInstance();
    }

}
