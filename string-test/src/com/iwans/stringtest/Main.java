package com.iwans.stringtest;

import java.beans.*;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "Hello!";
//        s = s.toUpperCase();
//        System.out.println(s);

//        String s1 = "Hello";
//        String s2 = "hello";
//        System.out.println(s2 == s1.toLowerCase());
//        System.out.println("s1.contains(\"ll\"); = " + s1.contains("ll"));
//        System.out.println("s1.indexOf(\"l\") = " + s1.indexOf("l"));;
//        System.out.println("s1.lastIndexOf(\"l\") = " + s1.lastIndexOf("l"));
//        System.out.println("s1.startsWith(\"H\") = " + s1.startsWith("H"));
//        System.out.println("s1.substring(0) = " + s1.substring(0));
//        System.out.println("s1.substring(2,4) = " + s1.substring(2,4));
//
//        String s3 = "  \tHello\r\n ";
//        System.out.println("s3 = " + s3 + "!");
//        System.out.println("s3.trim() = " + s3.trim() + "!");

//        String s4 = " \u3000Hello\u3000 ";
//        System.out.println("s4 = " + s4);
//        System.out.println("s4.trim() = " + "1" + s4.trim() + "1");
//        System.out.println("s4.strip() = " + "1" + s4.strip() + "1");
//        System.out.println("s4 = " + s4);
//        String s5 = "hellp";
//        String s6 = s5.replace("p", "o");
//        System.out.println(s5 + " | " + s6);
//        String s7 = "Hi, %s! Your score is %.1f";
//        System.out.println("s7 = " + s7);
//        System.out.println("s7.formatted = " + s7.formatted("Bob", 59.52));
//        int[] tmp2 = new int[10];
//        System.out.println(Arrays.toString(tmp2)); //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//        int[] tmp = new int[]{1, 2, 3, 4};
//        Scores a = new Scores(tmp);
//        a.printScores();
//        tmp[0] = 10;
//        a.printScores();

//        byte[] b = "helloţ".getBytes("UTF-8");
//        byte[] b = "hello".getBytes("Unicode");
//        byte[] c = "hello".getBytes(StandardCharsets.UTF_16);
////        for(byte i : b){
////            System.out.println(i);
////        }
////        for(byte i : c){
////            System.out.println("c: " + i);
////        }
//        String b1 = new String(b, "UTF-16");
//        System.out.println("b1: " + b1);
//        byte[] b = "a".getBytes("UTF-16");
//        byte[] b2 = "ê".getBytes("GBK");
//        for(byte i : b2){
//            System.out.println(i);
//        }
//        String c = new String(b, "Latin1");
//        String c2 = new String(b2, "GBK");
//        System.out.println("c: " + c);
//        System.out.println("c2: " + c2);

//        String s1 = "Hello!\uD83D";
//        readStringCode(s1);

//        String a = "Hello";
//        System.out.println(a);
//        System.out.println(\\u000d);
//        System.out.println("x");
//
//        String s = "s" + "s";
//        System.out.println(s);
//        Sub s = new Sub();
//        Base b = s;
//        System.out.println(s.field);
////        System.out.println(b.field);
////        System.out.println(((Base) s).field);
//        System.out.println(((Sub) b).field);
//        readStringCode("Hello");
//        StringBuilder bd = new StringBuilder();
//        bd.append("")
//          .append("")
//          .append("")
//          .append("");
//        Adder a = new Adder();
//        a.add(2)
//         .add(3)
//         .inc();
//        System.out.println(a.getSum());
//        String[] fields = {"name", "position", "salary"};
//        String table = "employee";
//        String insert = buildInsertSql(table, fields);
//        System.out.println(insert);
//        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
//        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
//        StringJoiner sj = new StringJoiner(", ", "Hello, ", "!");
//        String[] tmp = new String[]{"Bob", "John", "Aurore"};
//        for(String name:tmp){
//            sj.add(name);
//        }
//        System.out.println(sj.toString());

//        String[] fields = { "name", "position", "salary" };
//        String table = "employee";
//        String select = buildSelectSql(table, fields);
//        System.out.println(select);
//        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");

//        int i = 0;
//        Integer i1 = Integer.valueOf(1);
//        Integer i2 = Integer.valueOf("1");//静态工厂方法
//        Integer i3 = 3;//Integer.valueOf(3)
//        int i4 = i3;//i3.intValue()
//        byte i = -1;
//        readStr("Hello\uD83D\uDE02");
        BeanInfo info = null;
        try {
            info = Introspector.getBeanInfo(Person.class);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }

    }

    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder(1024);
        sb.append("INSERT INTO ")
          .append(table)
          .append(" (")
          .append(String.join(", ", fields))
          .append(") VALUES (?, ?, ?)");
        return sb.toString();
    }

    static String buildSelectSql(String table, String[] fields) {
        String ss = String.join(", ", fields);
        StringBuilder res = new StringBuilder(1024);
        res.append("SELECT ").append(ss).append(" FROM ").append(table);
        return res.toString();
    }

    static void readStr(String strs){
        for(int index = 0; index < strs.length();){
            int unic = strs.codePointAt(index);
            System.out.println();
            int flag = Character.charCount(unic);
            index += flag;
        }
    }

//    private static void readStringCode(String str){
//        for(int index = 0; index < str.length();){
//            char unicodeCode = str.charAt(index);
//            int unicode = unicodeCode;
//            int flag = Character.charCount(unicodeCode);
//            //do something
//            System.out.println(str.substring(index, index + flag));
//            index += flag;
//        }
//    }
}

//class Scores{
//    private int[] scores;
//    public Scores(int[] scores){
//        this.scores = scores.clone();
////        int[] tmp = scores;
////        this.scores = tmp; //NG
//    }
//
//    public void printScores(){
//        System.out.println(Arrays.toString(this.scores));
//    }
//}
//
//class Base{
//    private int field = 0;
//
//}
//
//class Sub extends Base{
//    public int field = 1;
//}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int getSum() {
        return sum;
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
