package org.example.services;

import org.example.enums.RolloutStrategyType;
import org.example.services.implementations.rolloutStrategies.BetaRolloutStrategy;
import org.example.services.implementations.rolloutStrategies.PercentageRolloutStrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RolloutStrategyFactory {

    private RolloutStrategyFactory() {

    }

    private static final Map<RolloutStrategyType, Class<? extends RolloutStrategy>> registry = new HashMap<>();

    static {
        registry.put(RolloutStrategyType.BETA, BetaRolloutStrategy.class);
        registry.put(RolloutStrategyType.PERCENTAGE, PercentageRolloutStrategy.class);
    }

    public static RolloutStrategy getInstance(RolloutStrategyType identifier) {
        try {
            Class<? extends RolloutStrategy> rolloutStrategyClass = registry.get(identifier);
            return rolloutStrategyClass.getConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
