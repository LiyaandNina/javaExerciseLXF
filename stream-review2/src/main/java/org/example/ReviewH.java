package org.example;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Files;

public class ReviewH {
    public static void main(String[] args) {
        File f = new File("C:\\Windows");
        File[] files = f.listFiles();
        printFiles(files);
        File[] exeFiles = f.listFiles(
                new FilenameFilter() {
                    @Override
                    public boolean accept(File pathname, String name) {
                        return name.endsWith(".exe");
                    }
                }
        );
        printFiles(exeFiles);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
