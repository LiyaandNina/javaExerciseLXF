package org.example.chain;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class DirectorHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        return !request.getName().equalsIgnoreCase("tom");
    }
}
