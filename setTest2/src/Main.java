import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Person, String> ss = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        ss.put(new Person("xiaowang"), "xiaowang");
        ss.put(new Person("laoli"), "laoli");
        for(Person p : ss.keySet()){
            System.out.println(p.name);
        }
        System.out.println(ss.get(new Person("xiaowang")));
    }
}

class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }
}