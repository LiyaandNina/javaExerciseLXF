import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer a = 1;
        Class stc = a.getClass();
        Class stcf = stc.getSuperclass();
        System.out.println("Integer Father: " + stcf);
        Class stcff = stcf.getSuperclass();
        System.out.println("Integer GrandFather: " + stcff);
        System.out.println("Interger inter: ");
        Class[] istc = stc.getInterfaces();
        printInterfaces(istc);
        System.out.println("Number inter :");
        Class[] istcf = stcf.getInterfaces();
        printInterfaces(istcf);

        Number.class.isAssignableFrom(Integer.class);

        String[] newWay = "Improving code with Lambda expressions in Java 8".split(" ");
        Arrays.sort(newWay, (s1, s2) -> {
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        });
    }

    private static void printInterfaces(Class[] istc){
        for(Class i : istc){
            System.out.println(i);
        }
    }
}
