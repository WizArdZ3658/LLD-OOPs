package org.example;

import org.example.enums.RateLimiterType;
import org.example.models.CustomRequest;
import org.example.models.User;
import org.example.services.RateLimiter;
import org.example.services.RateLimiterFactory;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.FIXED_COUNTER);
        rateLimiter.allowRequest(new User(), new CustomRequest());
    }
}


/*

Resource :-
https://medium.com/@choudharys710/lld-machine-coding-w-implementation-rate-limiter-34f87e74120f

 */