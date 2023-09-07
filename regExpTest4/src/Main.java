import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        parseTime("21:13:13");
        parseTime("24:13:13");
        parseTime("23:60:13");
    }
    public static void parseTime(String s) {
        Pattern p = Pattern.compile("([0-1][0-9]|2[0-3])\\:([0-5][0-9])\\:([0-5][0-9])");
        Matcher m = p.matcher(s);
        if(m.matches()){
            System.out.println(m.group(1) + "H");
            System.out.println(m.group(2) + "m");
            System.out.println(m.group(3) + "s");
        }else{
            System.out.println(s + " illegal.");
        }
    }
}