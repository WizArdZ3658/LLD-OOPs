package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


/*

Problem statement and Machine coding practice link: https://codezym.com/question/3

In a customer support system customers can create issues and agents can be assigned to resolve those issues. This
question has been asked in PhonePe machine coding LLD round.

Now there can be multiple ways to assign an agent to a given issue depending on expertise, availability, number of
open issues for agent, number of issues resolved by agent etc.

To implement these different assign strategies, we should use strategy design pattern.

Also, if you decide to keep data internally inside any strategy class then you will also need to use observer design
pattern to update those strategy classes when any issue is created, assigned or resolved.

https://medium.com/@prashant558908/solving-top-10-low-level-design-lld-interview-questions-in-2024-302b6177c869

 */