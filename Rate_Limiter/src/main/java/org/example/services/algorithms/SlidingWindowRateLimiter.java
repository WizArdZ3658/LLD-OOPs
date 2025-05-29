package org.example.services.algorithms;

import org.example.models.CustomRequest;
import org.example.models.User;
import org.example.services.RateLimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final Map<User, Queue<CustomRequest>> userRequestsMap;
    private static final Long duration = 5*60*1000L;
    private final Integer maxRequestLimit;

    public SlidingWindowRateLimiter(Integer maxRequestLimit) {
        this.userRequestsMap = new HashMap<>();
        this.maxRequestLimit = maxRequestLimit;
    }

    @Override
    public Boolean allowRequest(User user, CustomRequest request) {
        if (!this.userRequestsMap.containsKey(user)) {
            this.userRequestsMap.put(user, new LinkedList<>());
        }
        Queue<CustomRequest> requestQueue = this.userRequestsMap.get(user);

        long currentTimestamp = System.currentTimeMillis();

        while(!requestQueue.isEmpty() && requestQueue.peek().getTimestamp() < currentTimestamp - duration) {
            requestQueue.poll();
        }

        if (requestQueue.size() < this.maxRequestLimit) {
            requestQueue.add(request);
            this.userRequestsMap.put(user, requestQueue);
            return true;
        }
        return false;
    }
}
