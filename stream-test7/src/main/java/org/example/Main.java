package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("1Apple", "2Banana", "3Blackberry", "4Coconut", "5Avocado", "6Cherry", "7Apricots");
        Map<String, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        Collectors.toList()
                ));
        System.out.println(map);
    }
}