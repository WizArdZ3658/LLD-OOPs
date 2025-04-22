package org.example.services;

import org.example.models.Tweet;
import org.example.models.User;

import java.util.List;

public interface TwitterService {
    Tweet postTweet(User user, String description, List<String> attachments);
    List<Tweet> getTweets(User user);
    List<Tweet> getAllTweets(User user);
    void follow(User followerUser, User followeeUser);
    void unfollow(User followerUser, User followeeUser);
}
