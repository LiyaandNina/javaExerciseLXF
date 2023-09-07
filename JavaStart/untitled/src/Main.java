import java.util.*;

//class Test{
//    private String[] names;
//
//    //之所以用String... 而不是 String[] 是为了防止传入null，传入null时，前者为空数组，同样的，传入时对方不需要先构建
//    Test(String... names) {
//        this.names = names;
//    }
//}

class Test{
    private String name;
    private int age;
    private String sname;


    Test(String name, int age, String sname) {
        this.name = name;
        this.age = age;
        this.sname = sname;
    }

    public String getName() {
        return name;
    }
}

abstract class Animal{
    public abstract void run();
}

interface BigAnimal{
    void run();
    default void eat(){
        System.out.println("Big Animal Eat");
    }
}

interface BigCat{
    void shoot();
}

class Cat extends Animal{
    public void run(){
        System.out.println("Cat Run");
    }
}

class Tiger implements BigAnimal, BigCat{
    public void run(){
        System.out.println("Tiger Run");
    }

    public void shoot(){
        System.out.println("Miao");
    }

//    public void eat(){
//        System.out.println("Tiger Eat");
//    }
}

class Person {
    protected String name = "x";
    protected int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void run(){
        System.out.println("Person");
    }
}

class Student extends Person{
    protected int grade;

    Student(String name, int age, int grade){
        super(name, age);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run(){
        System.out.println("Student");
    }

}

public class Main {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        System.out.println(hashtable);
//        hashtable.containsKey(target - nums[2]);
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = 0;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return x == tmp || tmp / 10 == x;
    }

    //罗马数字转阿拉伯数字
    public static int romanToInt(String s) {
        Map<String, Integer> charTable = new HashMap<String, Integer>(){{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int value = charTable.get(s.charAt(i));
            if(i < (s.length() - 1) && value < charTable.get(s.charAt(i + 1))){
                res -= value;
            }else{
                res += value;
            }
        }
        return res;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            res = longestCommonPrefix(res, strs[i]);
            if(res == ""){
                break;
            }
        }
        return res;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        String res = "";
        int length = Math.min(str2.length(), str1.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        res = str1.substring(0, index);
        return res;
    }

    private static final Map<Character, Character> map = new HashMap<Character, Character>(){
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }
    } ;
    public static boolean isValid(String s) {
        if(!map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            }else if(map.get(stack.removeLast()) != c){
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args){
//        var nums = new int[]{0, 1, 2, 3, 2, 7, 4};
//        var target = 6;
//        var result = twoSum(nums, target);
//        System.out.println(result);
//        System.out.println(isPalindrome(1));
//        System.out.println(1 % 10);
//        var res = 1 / 10;
//        System.out.println("1/=10为" + res);
//        romanToInt("III");
//        int i = 1;
//        long a = 2L;
//        int c = 2_000;
//        float d = 2.1f;
//        double e = 2.1e29;
//        char f = 'f';
//        final double PI = 3.14;
//        int bb = 0 ^ 1;
//        int bbb = 0 ^ 1;
//        var cc = ~0;
//        int ccc = ~0;
//        System.out.println(cc);
// ======================================================================================
//            最长公共前缀
//        String[] str = new String[]{"al", "a"};
//        String res = longestCommonPrefix(str);
//        System.out.println(res);
//        ==========================================
        //测试
//        String tmp = "adaf";
//        var res = tmp.substring(0,0);
//        System.out.printf(res);
//        ==================================================================================
//        有效的括号
//        String s = new String("()");
//        System.out.println(isValid(s));
//        ====================================================================================
//        浮点数测试
//        double a = 1.0/10;
//        double b = 1 - 9.0/10;
//        System.out.println(a + "," + b);
//        ====================================================================================
//        布尔测试
//        boolean a = false;
//        boolean b = true;
//        System.out.println(a && (5/0 == 0));
//        System.out.println(b && (5/0 == 0));
//        ====================================================================================
//        三元运算
//        int ageOf = 5;
//        boolean ans = ageOf > 12 ? false : !(ageOf < 6);
//        System.out.println(ans);
//        ====================================================================================
//        多行字符串
//        String s = """
//                a
//                b
//                c
//                d""";
//        System.out.println(s);
//        =====================================================================================
//        字符串指针
//        String c = "s";
//        String t = c;
//        c = "t";
//        System.out.println(t);
//        =====================================================================================
//        int转string
//        int a = 72;
//        int b = 105;
//        int c = 65281;
//        // FIXME:
//        String s = "";
//        System.out.println(s + (char)a + (char)b + (char)c);
//        =====================================================================================
//        数组内的引用类型
//        String[] names = {"ABC", "XYZ", "zoo"};
//        String s = names[1];
//        names[1] = "cat";
//        System.out.println(s); // s是"XYZ
//        =====================================================================================
//        占位符
//        int n = 123450000;
//        System.out.printf("n=%d, hex=%08x", n, n);
//        =====================================================================================
//        引用类型判断内容相等需要equals
//        String a = "hello";
//        String b = "Hello".toLowerCase();
//        if(a == b){
//            System.out.println("a = b");
//        }else{
//            System.out.println("a != b");
//        }
//        if(a != null && a.equals(b)){
//            System.out.println("a = b");
//        }else{
//            System.out.println("a != b");
//        }
//        ====================================================================================
//        数组打印
//        int[] tmp = {1, 2, 3};
//        System.out.println(Arrays.toString(tmp));
//        System.out.println(tmp);
//        =================================================================
//        冒泡排序,两两对比，小（或大）的放到后面
//        int[] ns = {1,2,3,4,5,6,7,8,9,0};
//        for(int i = 0; i < ns.length - 1 ; i++){
//            for(int j = 0; j < ns.length - 1 -i; j++){
//                if(ns[j] < ns[j+1]){
//                    int tmp = ns[j];
//                    ns[j] = ns[j+1];
//                    ns[j+1] = tmp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(ns));
//        打印二位数组
//        int[][] nss = {{1,2}, {1}};
//        System.out.println(Arrays.deepToString(nss));
//        ================================================================
//        String类型不可变特性
        String[] tmp = {"a", "b", "c"};
        String[] tmp2 = tmp;
        tmp2[1] = "tmp[1]";
        String x = tmp2[1];
        tmp[1] = "x";
        System.out.println(Arrays.toString(tmp2));
        System.out.println("x: " + x);
        //始终输出a，x，c，因为tmp2实际上就是tmp，引用地址都相同

//        ===================================================================
//        Test testx = new Test(null,10,"");
//        String re = "name" + testx.getName() + "1";
//        re = "name" + null + "1";
//        System.out.println(re);
//        ===================================================================
//        子类继承父类时，构造函数如果没显式调用父类的构造函数，则默认调用父类无参构造函数，如果没有无参构造函数，则报错
//
//
//        ===================================================================
        Student sss = new Student("", 12, 1);
        Person p = sss;
        p.run();//调用的是 Student的run方法，但p的声明类型是Person，这就是多态，Polymorphic

        BigAnimal dbTiger = new Tiger();
        dbTiger.eat();
    }
}