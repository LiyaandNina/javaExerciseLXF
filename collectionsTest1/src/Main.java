import java.nio.charset.CoderResult;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<String> list = List.of();
//        List<String> list2 = Collections.emptyList();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list2.add(i);
        }
        System.out.println("list2: " + list2);
        Collections.shuffle(list2);
        System.out.println(list2);
    }
}