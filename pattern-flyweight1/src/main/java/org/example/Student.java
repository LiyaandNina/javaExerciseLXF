package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private static Map<String, Student> cache= new HashMap();
    private int id;
    private String name;

    public static Student create(int id, String name) {
        Student student = cache.get(name);
        if (student == null) {
            System.out.println(String.format("create new student(%s, %s)", id, name));
            student = new Student(id, name);
            cache.put(name, student);
        } else {
            System.out.println(String.format("use cache student(%s, %s)", id, name));
        }
        return student;
    }

    protected Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
