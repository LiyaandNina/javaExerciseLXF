package org.example;

public enum World {
    INSTANCE;

    private String name = "earth";

    private World() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
