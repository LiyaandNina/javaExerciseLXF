package org.example;

import java.util.Arrays;
import java.util.StringJoiner;

public class ReviewB {
    public static void main(String[] args) {
        String[] fruits = new String[]{"Apple", "Banana", "Bear"};
        Arrays.sort(fruits, String::compareTo);
        System.out.println(String.join(", ", fruits));
    }
}
