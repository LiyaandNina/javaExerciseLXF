package org.example;

import java.util.List;

public class ReviewP {
    public static void main(String[] args) {
        List<PersonP> persons = List.of(new PersonP("小明", 88), new PersonP("小黑", 62), new PersonP("小白", 45),
                new PersonP("小黄", 78), new PersonP("小红", 99), new PersonP("小林", 58));
        // 请使用filter过滤出及格的同学，然后打印名字:
        persons.stream()
               .filter(p -> p.score >= 60)
               .map(p -> p.name)
               .forEach(System.out::println);
    }
}

class PersonP {
    String name;
    int score;

    PersonP(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
