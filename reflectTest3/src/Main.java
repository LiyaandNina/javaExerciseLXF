import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        String str = "Hello world";
        Method m = String.class.getDeclaredMethod("substring", new Class[]{int.class, int.class});
        String r = (String) m.invoke(str, 6, 8);
        System.out.println("r: " + r);

        Method m1 = Integer.class.getDeclaredMethod("parseInt", String.class);
        Object value2 = (Integer) m1.invoke(null, "12345");
        System.out.println("value2: " + value2);

        Person p = new Person();
        Method m2 = Person.class.getDeclaredMethod("setName", String.class);
        m2.setAccessible(true);
        m2.invoke(p, "Xiao ming");

        Field f = Person.class.getField("name");
        Object name = f.get(p);
        System.out.println("name: " + name);
        f.set(p, "Xiao Li");
        Object name2 = f.get(p);
        System.out.println("name2: " + name2);;

        Class cls = p.getClass();
        Field ff = cls.getField("name");
        Method mm = cls.getDeclaredMethod("setName", String.class);
        mm.setAccessible(true);
        mm.invoke(p, "Xiao Ran");
        Object namef = ff.get(p);
        System.out.println("namef: " + namef);
    }
}

class Person{
    public String name;

    private void setName(String name){
        this.name = name;
    }
}
