package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Orange", "apple", "Banana")
            .stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println(list);
        List<String> list2 = List.of("Orange", "apple", "Banana")
                                .stream()
                                .sorted(String::compareToIgnoreCase)
                                .collect(Collectors.toList());
        System.out.println(list2);
        List<String> list3 = List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(list3);

        List<String> l4 = List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(l4);

        Stream<String> s1 = Stream.concat(List.of("A", "B", "A", "C", "B", "D").stream(),
                List.of("A", "B", "A", "C", "B", "D").stream());
        s1.forEach(System.out::print);
        System.out.println("");

        Stream<List<Integer>> s2 = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        Stream<Integer> i = s2.parallel().flatMap(l -> l.stream());
        System.out.println(i.collect(Collectors.toList()));
    }
}