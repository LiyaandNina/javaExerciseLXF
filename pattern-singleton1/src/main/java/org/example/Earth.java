package org.example;

public class Earth {
    private static final Earth instance = new Earth();
    private String name = "earth";

    private Earth() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Earth getInstance() {
        return instance;
    }
}
