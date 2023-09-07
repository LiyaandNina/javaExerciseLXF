package org.example;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream input = Main.class.getResourceAsStream("/book.json");
    }
}