import java.lang.reflect.AnnotatedType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if(t instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) t;
            Type[] ty = pt.getActualTypeArguments();
            Type intpairCl = ty[0];
            Class<?> intpairTrCl = (Class<?>) intpairCl;
            System.out.println(intpairTrCl);
            String s = "{\"name\": \"-DWIBU_CTP_YAML_PATH=${sourceDir}/../prot.yaml\"}";
            System.out.println(s);
        }
    }
}

class Pair<T> {
    private T first;
    private T last;
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
}

class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
