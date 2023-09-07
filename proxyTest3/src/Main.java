import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        JK huang = new JK("huang", "School");
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName() == "studying"){
                    System.out.println(huang.getName() + " is Studying.");
                }
                if(method.getName() == "resting"){
                    System.out.println(huang.getName() + " is Resting.");
                }
                return method.invoke(huang, args);
            }
        };
        Student jkProxy = (Student) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                new Class[]{Student.class},
                handler
        );
        jkProxy.resting();
        jkProxy.studying();

        new Man().get();
    }
}
