package org.example;

import java.util.Arrays;

public class ReviewA {
    public static void main(String[] args) {
        String[] fruits = new String[]{"Apple", "Banana", "Bear"};
        Arrays.sort(fruits, ReviewA::cmp);
        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}