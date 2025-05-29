package org.example.services.algorithms;

import org.example.models.CustomRequest;
import org.example.models.User;
import org.example.services.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class FixedCounterRateLimiter implements RateLimiter {
    private final Map<User, Integer> requestsCount;
    private final Long windowGap;
    private final Map<User, Long> lastRefill;
    private final Integer maxRequestLimit;

    public FixedCounterRateLimiter(Integer maxRequestLimit) {
        this.requestsCount = new HashMap<>();
        this.windowGap = 5*60*1000L;
        this.lastRefill = new HashMap<>();
        this.maxRequestLimit = maxRequestLimit;
    }

    @Override
    public Boolean allowRequest(User user, CustomRequest request) {
        Long currentTimeStamp = System.currentTimeMillis();

        if (!this.requestsCount.containsKey(user)) {
            this.requestsCount.put(user, this.maxRequestLimit);
            this.lastRefill.put(user, currentTimeStamp);
        }

        if (this.lastRefill.get(user) < currentTimeStamp - this.windowGap) {
            this.lastRefill.put(user, currentTimeStamp);
            this.requestsCount.put(user, this.maxRequestLimit);
        }

        if (this.requestsCount.get(user) > 0) {
            this.requestsCount.put(user, this.requestsCount.get(user) - 1);
            return true;
        } else {
            return false;
        }
    }
}
