package org.example;

import java.sql.Connection;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class PooledConnectionProxy extends AbstractConnectionProxy {
    Connection conn;
    Queue<PooledConnectionProxy> idleQueue;

    public PooledConnectionProxy(Queue<PooledConnectionProxy> idleQueue, Connection conn) {
        this.idleQueue = idleQueue;
        this.conn = conn;
    }

    @Override
    public void close() {
        System.out.println("Fake close and put in idleQueue: " + conn);
        idleQueue.offer(this);
    }

    @Override
    public Connection getRealConnection() {
        return conn;
    }
}
