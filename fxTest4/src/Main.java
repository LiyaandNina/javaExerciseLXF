import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Pair<Number> p = new Pair<>(123, 456);
        System.out.println(p.getClass());
        Constructor[] c = p.getClass().getConstructors();
        for(Constructor i : c){
            Field[] f = i.getDeclaringClass().getFields();
            for(Field x : f){
                System.out.println(x.getAnnotatedType());
            }
        }
    }
}

class Pair<T>{
    public T first;
    public T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
