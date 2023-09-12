package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        System.out.println("Main start...");
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("Main end...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Thread t = new HelloThread();
        System.out.println("My thread start...");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Interruptted!");
        }
        t.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}