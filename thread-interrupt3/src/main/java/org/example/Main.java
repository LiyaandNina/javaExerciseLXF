package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        System.out.println("Main start...");
        t.start();
        Thread.sleep(7);
        t.running = false;
        t.join();
        System.out.println("Main end...");
    }
}

class MyThread extends Thread {
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + "hello...");
        }
        System.out.println("end...");
    }
}