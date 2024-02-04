package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReviewE {
    public static void main(String[] args) {
        var streama = Stream.of("A", "B", "C");
        streama.forEach(System.out::println);
        Stream<String> stream1 = Arrays.stream(new String[]{"A", "b", "c"});
        Stream<String> stream2 = List.of("a", "b", "c").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }
}
