package org.example;

import java.util.Arrays;

public class ReviewD {
    public static void main(String[] args) {
        String[] array = new String[] { "apple", "Orange", "banana", "Lemon" };

        /*
        * FunctionalInterface 单方法接口
        * 允许传入
        * 接口的实现类
        * lambda 表达式
        * 符合方法签名的静态方法
        * 符合方法签名的实例方法（实例类型作为第一个参数传入）
        * 符合方法签名的构造方法（实例类型被看作返回类型）
        */

        Arrays.sort(array, ReviewD::compareToIngore);
        System.out.println(String.join(", ", array));
        Arrays.sort(array, ReviewD::compareTo);
        System.out.println(String.join(", ", array));
        Arrays.sort(array, (s1, s2) -> s1.compareTo(s2));
    }

    static int compareToIngore(String s1, String s2) {
        return s1.toLowerCase().compareTo(s2.toLowerCase());
    }

    static int compareTo(String s1, String s2) {
        return s1.compareTo(s2);
    }


}
