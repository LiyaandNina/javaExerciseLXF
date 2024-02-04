package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReviewJ {
    public static void main(String[] args) {
        printAllFiles(Paths.get("D:\\javaProject\\stream-review2").toFile());
    }

    static void printAllFiles(File file) {
        printAllFiles(file, 0);
    }

    static void printAllFiles(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.printf("    ");;
        }
        if (file.isDirectory()) {
            System.out.printf("\\");
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files != null) {
            level++;
            for (File f: files) {
                printAllFiles(f, level);
            }
        }
    }
}