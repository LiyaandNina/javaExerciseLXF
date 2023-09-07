package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        String[] array = new String[] { "apple", "Orange", "banana", "Lemon" };
        // 请使用忽略大小写排序，并改写为方法引用:
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }
}
