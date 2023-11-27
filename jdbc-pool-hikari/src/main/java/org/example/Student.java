package org.example;

public class Student {
    private long id;
    private String name;
    private boolean gender;
    private int grade;
    private int score;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{Student: id=%s, name=%s, gender=%s, grade=%d, score=%d}", this.id, this.name,
                this.gender ? "male" : "female", this.grade, this.score);
    }
}
