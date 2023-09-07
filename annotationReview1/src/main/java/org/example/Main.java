package org.example;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("xiaoming", 1000);
        check(person);
    }

    public static void check(Person person) throws IllegalAccessException {
        Field[] fields = person.getClass().getFields();
        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(person);
                if (value instanceof String s) {
                    System.out.println("Check " + (s.length() < range.max() && s.length() > range.min() ? "success" : "failed"));
                }
                if (value instanceof Integer i) {
                    System.out.println("Check " + (i < range.max() && i > range.min() ? "success" : "false"));
                }
            }
        }
    }
}