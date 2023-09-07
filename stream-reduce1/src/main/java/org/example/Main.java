package org.example;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int f = Stream.of(1, 2, 3, 4, 5, 6, 7 ,8 ,9)
                      .reduce(1, (acc, n) -> acc = acc * n);
        Optional<Integer> t = Stream.of(1, 2, 3, 4, 5, 6, 7 ,8 ,9)
                                    .reduce( (acc, n) -> acc = acc * n);
        System.out.println(f);
        System.out.println(t.get());
    }
}