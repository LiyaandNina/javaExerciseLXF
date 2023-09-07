import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        List<Integer> list = List.of(1, 2 ,3, 4);
//        Integer[] array1 = list.toArray(new Integer[4]);
//        Number[] array2 = list.toArray(new Number[4]);
//        Object[] array3 = list.toArray();
//        for(Integer i : array1){
//            System.out.println(i);
//        }
//
//        Integer[] array4 = list.toArray(new Integer[list.size()]);

        // only read could not add
//        list.add(10);
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list){
        int index = 0;
        for(int i : list){
            if(i != index+10){
                return i;
            }
            index++;
        }
        return 20;
    }
}