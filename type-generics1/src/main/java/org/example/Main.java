package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //如果不指定泛型，实际上是Object
//        List list = new ArrayList();
        List<String> list = new ArrayList<>();
        list.add("Hello");
        // 不指定泛型，此处list.get 返回的就是Object
        String first = list.get(0);
    }
}

class Person implements Comparable<Person> {

    private int score;

    private String name;

    public Person(int score, String name) {
        super();
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return (this.score > person.getScore()) ? 1 : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}