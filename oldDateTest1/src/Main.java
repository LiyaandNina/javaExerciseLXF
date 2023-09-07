import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("day: " + date.getDate());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
        System.out.println("get year: " + date.getYear());
        System.out.println("get month:" + date.getMonth());

        var dateFormat = new SimpleDateFormat("yyyy MM dd ss:mm:HH");
        System.out.println(dateFormat.format(date));
    }
}