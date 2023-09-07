package org.example.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal getDiscount(BigDecimal total);
}
