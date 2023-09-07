import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        JaveDeveloper jack = new JaveDeveloper();
        Developers jackProxy = (Developers) Proxy.newProxyInstance(
                jack.getClass().getClassLoader(),
                new Class[]{Developers.class},
                (proxy1, method, args1) -> {
                    if(method.getName() == "coding"){
                        System.out.println("Zack is coding");
                    }
                    if(method.getName() == "debuging"){
                        System.out.println("Zack is debugging");
                    }
                    return method.invoke(jack, args);
                }
        );
        jackProxy.coding();
        jackProxy.debuging();
    }

}

interface Developers{
    void coding();
    void debuging();
}

class JaveDeveloper implements Developers{
    @Override
    public void coding(){
        System.out.println("JavaDeveloper is coding...");
    }

    @Override
    public void debuging(){
        System.out.println("JavaDeveloper is debuging...");
    }
}
