import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName() == "coding") {
                    System.out.println("Coding...");
                }
                if(method.getName() == "debug"){
                    System.out.println("Debug...");
                }
                return null;
            }
        };

        Developer jack = (Developer) Proxy.newProxyInstance(Developer.class.getClassLoader(), new Class[]{Developer.class}, handler);
        jack.coding();
        jack.debug();
    }

}

interface Developer{
    void coding();
    void debug();
}
