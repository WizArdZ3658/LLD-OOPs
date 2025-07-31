package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

/*

Problem statement and Machine coding practice link: https://codezym.com/question/9

This question is asked many times in Microsoft LLD interviews.

Any text document has characters arranged in rows and columns. Also each character can have its own style parameters
like font name, font size, bold, italic etc. you should be able to

add and delete characters with different styles
read row of characters or lines
We make use of the fact that even if there can be 10K or 100K or more characters in a text document, still number of
styles used will be limited, like few 100’s or thousand.

So it makes sense to use flyweight design pattern here. We share character style as constant intrinsic state and reduce
memory footprint of program

https://medium.com/@prashant558908/solving-top-10-low-level-design-lld-interview-questions-in-2024-302b6177c869

 */