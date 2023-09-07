import java.util.*;

public class Main {
    public static void main(String[] args) {
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> tmpStack = new LinkedList<>();
        int tmpNumber = n;
        String res = "";

        while(tmpNumber / 16 != 0){
            tmpStack.push(Integer.toHexString(tmpNumber % 16));
            tmpNumber = tmpNumber/16;
        }

        tmpStack.push(Integer.toHexString(tmpNumber % 16));

        while(tmpStack.size() != 0) {
            res += tmpStack.poll();
        }

        return res;
    }
}