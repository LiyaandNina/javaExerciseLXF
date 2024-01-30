package org.example;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReviewM {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.generate(new FBSupplier());
        stream.limit(20).forEach(System.out::println);
    }
}

class FBSupplier implements Supplier<Integer> {
    private int a = 1;
    private int b = 0;

    public Integer get() {
        int res = a + b;
        a = b;
        b = res;
        return res;
    }
}
