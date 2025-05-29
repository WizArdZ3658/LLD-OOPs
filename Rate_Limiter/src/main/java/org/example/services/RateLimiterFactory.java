package org.example.services;

import org.example.enums.RateLimiterType;
import org.example.services.algorithms.FixedCounterRateLimiter;
import org.example.services.algorithms.SlidingWindowRateLimiter;
import org.example.services.algorithms.TokenBucketRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterFactory {
    private static final Map<RateLimiterType, RateLimiter> serviceRegistry = new HashMap<>();

    static {
        serviceRegistry.put(RateLimiterType.SLIDING_WINDOW, new SlidingWindowRateLimiter(100));
        serviceRegistry.put(RateLimiterType.TOKEN_BUCKET, new TokenBucketRateLimiter(100));
        serviceRegistry.put(RateLimiterType.FIXED_COUNTER, new FixedCounterRateLimiter(100));
    }

    public static RateLimiter getRateLimiter(RateLimiterType type) {
        if (serviceRegistry.containsKey(type)) {
            return serviceRegistry.get(type);
        }
        return serviceRegistry.get(RateLimiterType.SLIDING_WINDOW);
    }
}
