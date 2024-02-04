package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReviewS {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list1 = stream.filter(n -> (n != null && !n.isBlank())).collect(Collectors.toList());
        System.out.println(list1);

        List<String> list = List.of("Apple", "Banana", "Orange");
        String[] str =  list.stream().toArray(String[]::new);
    }
}
