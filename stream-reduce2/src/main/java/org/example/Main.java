package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                .map(kv -> {
                    String[] str = kv.split("\\=", 2);
                    return Map.of(str[0], str[1]);
                })
                .reduce(new HashMap<>(), (acc, kvm) -> {
                    acc.putAll(kvm);
                    return acc;
                });
        map.forEach((k, v) -> System.out.println(k + ": " + v));
//        String s = "profile=native=1=2";
//        String[] x = s.split("\\=", 3);
//        System.out.println(x);
    }
}