import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
//        LocalDate d = LocalDate.now();
//        LocalTime t = LocalTime.now();
//        LocalDateTime dt = LocalDateTime.now();
//        LocalDate d = dt.toLocalDate();
//        LocalTime t = dt.toLocalTime();
        LocalTime t = LocalTime.of(15,16, 17);
        LocalDate d = LocalDate.of(2023, 7, 30);
        LocalDateTime dt = LocalDateTime.of(2023, 7, 30, 15, 16, 17);
        LocalDateTime dt1 = LocalDateTime.parse("2023-08-02T09:30:14");
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
        System.out.println(dt1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.format(dt1));
        LocalDateTime dt2 = LocalDateTime.parse("2023-07-31 09:30:14", dateTimeFormatter);
        System.out.println("dt2: " + dt2);

        LocalDateTime dt3 = dt2.minusDays(30);
        System.out.println("dt3: " + dt3);
        LocalDateTime dt4 = dt2.minusMonths(1);
        System.out.println("dt4: " + dt4);

        LocalDateTime firstMonday = LocalDateTime.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("firstMonday: " + dateTimeFormatter2.format(firstMonday));

        System.out.println(dt4.isBefore(dt3));
        System.out.println(dt4.isBefore(dt2));
    }
}