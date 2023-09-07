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
        Helper[] helpers = new Helper[]{new Helper(), new Helper()};
        Arrays.sort(array, String::compareTo);
        // 请使用忽略大小写排序，并改写为方法引用:
        Arrays.sort(helpers, Helper::compare);
        System.out.println(String.join(", ", array));
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}


class Helper {
    public String helpp;

    public Helper() {
        this.helpp = "aa";
    }

    public int compare(Helper this, Helper b) {
        return this.helpp == b.helpp ? 1 : 0;
    }
}