package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(k -> k != null&&!k.isBlank()).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println(list);
    }
}