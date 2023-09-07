import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person a = new Person("xiaoming", 12);
        Person b = new Person("azhangsan", 41);
        Person[] p = new Person[]{a, b};
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
    }
}

class Person implements Comparable<Person>{
    public String name;
    public int score;

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public Person() {
    }

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "xname='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
