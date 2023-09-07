package org.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        m -> m.substring(0, m.indexOf(":")),
                        m -> m.substring(m.indexOf(":") + 1)));
        System.out.println(map);
    }
}