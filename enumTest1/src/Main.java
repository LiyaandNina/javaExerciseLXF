import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
//        Color a = Color.YELLOW;
//        Constructor b = Color.class.getConstructor();
////        b.setAccessible(true);
////        Color c = (Color) b.newInstance();
////        System.out.println(c);
        Method[] a = Color.class.getMethods();
        for(Method m: a){
            System.out.println(m.getName());
        }
//        Constructor c = Color.class.getConstructor(int.class);
        Method a1 = Color.class.getDeclaredMethod("name");
    }
}
