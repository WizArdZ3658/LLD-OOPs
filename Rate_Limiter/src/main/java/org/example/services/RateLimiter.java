package org.example.services;

import org.example.models.CustomRequest;
import org.example.models.User;

public interface RateLimiter {
    public Boolean allowRequest(User user, CustomRequest request);
}
