package org.example;

public class Main {
    public static void main(String[] args) {
        var rarray = new ReverseCollection<>("apple", "pear", "orange", "banana");
        for (String fruit : rarray) {
            System.out.println(fruit);
        }
    }
}