import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if(m.matches()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }else{
            System.out.println("not match");
        }
//        m.matches();
//        System.out.println(m.group(1));
//        System.out.println(m.group(2));
    }
}