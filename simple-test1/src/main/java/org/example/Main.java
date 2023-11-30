package org.example;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[]{new User("a"), new User("b")};
        for(User u : users) {
            System.out.println(users);
        }
    }
}