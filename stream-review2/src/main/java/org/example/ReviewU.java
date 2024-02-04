package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReviewU {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);

        List<String> list1 = List.of("A", "B", "A", "C", "B", "D")
                                 .stream()
                                 .parallel()
                                 .distinct()
                                 .collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = List.of("Orange", "apple", "Banana")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(list2);

        Stream<String> s1 = List.of("A", "B", "C").stream();
        Stream<String> s2 = List.of("D", "E").stream();
        List<String> list3 = Stream.concat(s1, s2).collect(Collectors.toList());
        System.out.println(list3);

        Stream<List<Integer>> s = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        Stream<Integer> stream1 = s.flatMap(x -> x.stream());
        stream1.forEach(System.out::print);
    }
}
