package org.example;

import org.example.services.TwitterService;
import org.example.services.TwitterServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        TwitterService twitterService = new TwitterServiceImpl();

    }
}