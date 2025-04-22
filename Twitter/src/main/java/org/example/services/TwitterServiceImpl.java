package org.example.services;

import org.example.models.Tweet;
import org.example.models.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CustomComparator implements Comparator<Tweet> {

    @Override
    public int compare(Tweet o1, Tweet o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }
}

public class TwitterServiceImpl implements TwitterService {

    private static Integer tweetCount = 0;
    private final List<Tweet> tweets;

    public TwitterServiceImpl() {
        this.tweets = new ArrayList<>();
    }

    @Override
    public Tweet postTweet(User user, String description, List<String> attachments) {
        Tweet tweet = new Tweet();
        tweet.setId(tweetCount++);
        tweet.setUser(user);
        tweet.setMessage(description);
        tweet.setAttachments(attachments);
        this.tweets.add(tweet);
        user.getPostedTweets().add(tweet);
        return tweet;
    }

    @Override
    public List<Tweet> getTweets(User user) {
        return user.getPostedTweets();
    }

    @Override
    public List<Tweet> getAllTweets(User user) {
        List<Tweet> allTweets = new ArrayList<>();
        for (User followeeUser : user.getFollowing()) {
            allTweets.addAll(followeeUser.getPostedTweets());
        }
        allTweets.sort(new CustomComparator());
        return allTweets;
    }

    @Override
    public void follow(User followerUser, User followeeUser) {
        followerUser.getFollowing().add(followeeUser);
        followeeUser.getFollowers().add(followerUser);
    }

    @Override
    public void unfollow(User followerUser, User followeeUser) {
        followerUser.getFollowing().remove(followeeUser);
        followeeUser.getFollowers().remove(followerUser);
    }
}
