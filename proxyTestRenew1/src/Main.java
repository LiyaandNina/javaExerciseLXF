import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        JKStudents jiumiko = new JKStudents();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName() == "studying"){
                    System.out.println("jiumiko is JK");
                }
                if(method.getName() == "testing"){
                    System.out.println("jiumiko is JK");
                }
                return method.invoke(jiumiko, args);
            }
        };
        Students jiumikoProxy = (Students) Proxy.newProxyInstance(Students.class.getClassLoader(),
                new Class[]{Students.class},
                handler);
        jiumikoProxy.studying();
        jiumikoProxy.testing();
    }

}

interface Students{
    void studying();
    void testing();
}

class JKStudents implements Students{

    public String names;
    public void studying(){
        System.out.println("JK is studying");
    }

    public void testing(){
        System.out.println("JK is testing");
    }
}
