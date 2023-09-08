package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6 ; i++) {
            executor.submit(new MyTask("" + i));
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Start MyTask " + this.name + "...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task" + name);
    }
}