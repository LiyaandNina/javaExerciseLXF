import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Person xiaoming = new Person("xiaoming", -1);
    }
}

class Person{

    @Range(min = 2, max = 4)
    public String name;

    @Range
    public int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    void check(Person person) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = Person.class.getFields();
        for(Field field : fields){
            Range range = field.getAnnotation(Range.class);
            if(range != null){
                Object value = field.get(person);
                if(value instanceof String s){
                    //do something
                    if(s.length() < range.min() || s.length() > range.max()){
                        throw new IllegalArgumentException();
                    }
                }
                if(value instanceof Integer s){
                    //do something
                    if(s < range.min() || s > range.max()){
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

}