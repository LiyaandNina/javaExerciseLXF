package org.example.chain;

import java.math.BigDecimal;

public class Request {

    private String name;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("{Request: name=%s, amount=%s}", this.name, this.amount);
    }
}
