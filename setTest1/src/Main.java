import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Set<String> ss = new HashSet<>();
        Set<String> ss = new TreeSet<>();
        System.out.println(ss.add("task"));
        System.out.println(ss.add("banana"));
        System.out.println(ss.add("apple"));
        System.out.println(ss.add("apple"));
        System.out.println(ss.remove("apple"));
        System.out.println(ss.remove(("Boe")));
        System.out.println(ss.size());
        for(String s : ss){
            System.out.println(s);
        }
    }
}