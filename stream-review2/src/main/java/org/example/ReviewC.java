package org.example;

import java.util.ArrayList;
import java.util.List;

public class ReviewC {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> people = new ArrayList<>();
        for(String name: names) {
            people.add(new Person(name));
        }
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

}
