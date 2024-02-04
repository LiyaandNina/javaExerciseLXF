package org.example;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReviewF {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.generate(new NatualSupplier());
        //无限序列需要转变为有限序列才能执行 forEach count 等最终求值操作
        stream.limit(20).forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    private int n = 0;

    public Integer get() {
        n++;
        return n;
    }
}
