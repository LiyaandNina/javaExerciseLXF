package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> {
            System.out.println("Hello!");
        });
        System.out.println("Main start...");
        hello.start();
        hello.join();
        System.out.println("Main end...");
    }
}