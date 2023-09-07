package org.example;

public class Student implements Cloneable {
    private int id;
    private String name;
    private int score;

    @Override
    public Object clone() {
        Student s = new Student();
        s.setId(this.id);
        s.setName(this.name);
        s.setScore(this.score);
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
