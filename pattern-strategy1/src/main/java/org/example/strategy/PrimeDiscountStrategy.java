package org.example.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrimeDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(new BigDecimal("0.2")).setScale(2, RoundingMode.DOWN);
    }
}
