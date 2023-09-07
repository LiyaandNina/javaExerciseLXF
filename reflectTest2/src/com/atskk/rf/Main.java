package com.atskk.rf;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws Exception {
//        Class stdClass = Student.class;
//        System.out.println(stdClass.getField("score"));
//        System.out.println(stdClass.getField("name"));
//        System.out.println(stdClass.getDeclaredField("grade"));
//        System.out.println("================================================================");
//        Field f = String.class.getDeclaredField("value");
//        f.getName();
//        f.getType();
//        int m = f.getModifiers();
//        Modifier.isFinal(m);
//        Modifier.isPrivate(m);
//        Modifier.isPublic(m);
//        Modifier.isProtected(m);
//        Modifier.isStatic(m);
//        System.out.println("do something");

        Object p = new Person("A Li");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        f.set(p, "Xi");
        System.out.println(value);
        System.out.println(f.get(p));
    }
}

class Student extends Person{
    public int score;
    private int grade;
}

class Person{
    private String name;

    public Person(){
    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
