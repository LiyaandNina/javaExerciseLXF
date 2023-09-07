package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

public class LazyConnectionProxy extends AbstractConnectionProxy {
    private Supplier<Connection> supplier;
    private Connection conn = null;

    public LazyConnectionProxy(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void close() throws SQLException {
        if (conn != null) {
            System.out.println("close connection..." + conn);
            super.close();
        }
    }

    @Override
    public Connection getRealConnection() {
        if (conn == null) {
            conn = supplier.get();
        }
        return conn;
    }
}
