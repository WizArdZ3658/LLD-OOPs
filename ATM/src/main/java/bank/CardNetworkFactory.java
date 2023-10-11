package bank;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CardNetworkFactory {

    private CardNetworkFactory() {}

    private static final Map<String, Class<? extends ICardNetwork>> registry = new HashMap<>();
    
    static {
        registry.put("visa", Visa.class);
        registry.put("mastercard", Mastercard.class);
    }

    public static ICardNetwork getInstance(String identifier) {
        try {
            Class<? extends ICardNetwork> cardNetworkClass = registry.get(identifier);
            return cardNetworkClass.getConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
