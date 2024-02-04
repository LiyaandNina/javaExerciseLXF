package org.example;

import java.util.Iterator;
import java.util.List;

public class ReviewV {
    public static void main(String[] args) {
        // ArrayList 和 LinkedList 是 List 常用的两种实现
        // 遍历 Iterable 对象坚持用 Iterator的方法
        List<String> list = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }
    }
}
