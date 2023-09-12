package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        System.out.println("Main start...");
        t.start();
        Thread.sleep(100);
        t.interrupt();
        t.join();
        System.out.println("Main end...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}