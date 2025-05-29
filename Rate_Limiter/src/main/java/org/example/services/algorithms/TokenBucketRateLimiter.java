package org.example.services.algorithms;

import org.example.models.CustomRequest;
import org.example.models.User;
import org.example.services.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter implements RateLimiter {
    private final Map<User, Long> lastRefill;
    private final Map<User, Integer> tokensLeft;
    private final Integer maxTokenLimit;
    private static final Double rateOfRefillPerSec = 1.0;


    public TokenBucketRateLimiter(Integer maxRequestLimit) {
        this.lastRefill = new HashMap<>();
        this.tokensLeft = new HashMap<>();
        this.maxTokenLimit = maxRequestLimit;
    }

    @Override
    public Boolean allowRequest(User user, CustomRequest request) {
        Long currentTimestamp = System.currentTimeMillis();

        Long timeElapsed = (currentTimestamp - this.lastRefill.getOrDefault(user, 0L))/1000;

        Integer newTokens = Math.toIntExact(Math.round(timeElapsed * rateOfRefillPerSec));

        Integer finalTokenCountForUser = Math.min(
                this.maxTokenLimit,
                this.tokensLeft.getOrDefault(user, 0) + newTokens
        );
        Integer earlierTokenCountForUser = this.tokensLeft.get(user);
        this.tokensLeft.put(user, finalTokenCountForUser);

        if (finalTokenCountForUser > earlierTokenCountForUser) {
            this.lastRefill.put(user, currentTimestamp);
        }

        if (this.tokensLeft.get(user) > 0) {
            this.tokensLeft.put(user, this.tokensLeft.get(user) - 1);
            return true;
        } else {
            return false;
        }

    }
}
