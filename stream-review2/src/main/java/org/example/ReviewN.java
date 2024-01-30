package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

public class ReviewN {
    public static void main(String[] args) {
        String[] array = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };
        // 请使用map把String[]转换为LocalDate并打印:
//        Arrays.stream(array).map(new DateMapper()).forEach(System.out::println);
        Arrays.stream(array)
              .map(str -> str.replaceAll(" ", ""))
              .map(LocalDate::parse)
              .forEach(System.out::println);
    }
}

//class DateMapper implements Function<String, LocalDate> {
//    public LocalDate apply(String string) {
//        return LocalDate.parse(string.replaceAll(" ", ""));
//    }
//}