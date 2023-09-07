package org.example;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable {

    private Callable<?> t;

    public RunnableAdapter(Callable<?> t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            t.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
