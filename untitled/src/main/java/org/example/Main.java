package org.example;

import java.io.IOException;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) throws IOException {
        LongStream fib = LongStream.generate(new FibSupplier());
        // 打印Fibonacci数列：1，1，2，3，5，8，13，21...
        fib.limit(10).forEach(System.out::println);
    }
}

class FibSupplier implements LongSupplier {
    private long p1, p3 = 0;
    private long p2 = 1;

    @Override
    public long getAsLong() {
        p1 = p2;
        p2 = p3;
        p3 = p1 + p2;
        return p3;
    }
}