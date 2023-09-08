package org.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Thread t = new TimerThread();
        System.out.println("Main start...");
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("Main end...");
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}