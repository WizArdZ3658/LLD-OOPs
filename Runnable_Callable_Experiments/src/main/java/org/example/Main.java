package org.example;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Test implements Runnable {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(5);

        try {
            System.out.println("runnable thread sleeping for " + randomNumber * 1000);
            Thread.sleep(randomNumber * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " : I am running");
    }
}

class TestCallable implements Callable<String> {
    private String name;

    public TestCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Random generator = new Random();
        int randomNumber = generator.nextInt(5);
        System.out.println("callable thread sleeping for " + randomNumber * 1000);
        Thread.sleep(randomNumber * 1000);
        return this.name + " : I am running";
    }
}

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new Test("Somnath"));
        Thread t2 = new Thread(new Test("Amrita"));
        t1.start();
        t2.start();


        FutureTask<String> task = new FutureTask<>(new TestCallable("Somnath"));
        FutureTask<String> task2 = new FutureTask<>(new TestCallable("Amrita"));



        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task2);
        t3.start();
        t4.start();

        System.out.println(task.get());
        System.out.println(task2.get());
    }
}