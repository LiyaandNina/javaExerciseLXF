package org.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReviewI {
    public static void main(String[] args) {
        Path p1 = Paths.get(".", "project", "study");
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath();
        System.out.println(p2);
        Path p3 = p1.normalize();
        System.out.println(p3);
        File f = p1.toFile();
        System.out.println(f);
        Path p4 = Paths.get("..").toAbsolutePath();
        System.out.println("p4 " + p4);
        for (Path p : Paths.get("..").toAbsolutePath()) {
            System.out.println(" " + p);
        }
    }
}
