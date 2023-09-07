import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime t = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE yyyy MM dd HH:mm:ss.SSS zzz", Locale.CHINA);
        System.out.println(dtf.format(t));
        System.out.println(t);

        Instant d = new Date().toInstant();
        ZonedDateTime newNow = d.atZone(ZoneId.systemDefault());
        System.out.println(dtf.format(newNow));


    }
}