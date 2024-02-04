package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReviewO {
    public static void main(String[] args) {
        IntStream.of(1, 2, 3 ,4, 5, 6, 7, 8, 9)
                 .filter(n -> n % 2 != 0);
//                 .forEach(System.out::println);
        Stream<LocalDate> stream = Stream.generate(new LocalDateSupplier());
        stream.filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
              .limit(30)
              .forEach(System.out::println);
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    private LocalDate start = LocalDate.of(2000,1,1);
    private long n = -1;

    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
