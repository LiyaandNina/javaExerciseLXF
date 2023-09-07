import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student xm = new Student("xiao ming", 100);
        map.put("xiao ming", xm);
        Student target = map.get("xiao ming");
        System.out.println(target == xm);
        System.out.println(target.score);
        Student another = map.get("Bob");
        System.out.println(another);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        for(String s : map1.keySet()){
            System.out.println(map1.get(s));
        }
        for(Map.Entry<String, Integer> entry: map1.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

class Student {
    public String name;
    public int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}