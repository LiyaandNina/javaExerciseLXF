import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        System.out.println(list.size());
        list.add(null);
        //not null
        List<Integer> list1 = List.of(1, 2, 3, 4);

        //read list
        //do not recommand
        for(int i = 0; i < list.size(); i++){
            list.get(i);
        }
        //iterator recommand:
        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            iterator.next();
        }
        //could be simplified( for each will use iterator)
        for(String s: list){
            System.out.println(s);
        }
    }
}
