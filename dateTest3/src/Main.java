import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime localZonedTime = ZonedDateTime.now();
        ZonedDateTime newYorkZonedTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("lt: " + localZonedTime);
        System.out.println("nyt: " + newYorkZonedTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Paris"));
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime1 = zonedDateTime.toLocalDateTime();
        System.out.println("=====");
        System.out.println(localDateTime1);
        System.out.println(zonedDateTime);
    }
}