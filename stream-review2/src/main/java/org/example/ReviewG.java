package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReviewG {
    public static void main(String[] args) throws IOException {
//        File f = new File("..");
//        System.out.println(f.getPath());
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.getCanonicalPath());
        File f2 = File.createTempFile("test", ".txt");
        f2.deleteOnExit();
        System.out.println(f2.isFile());
        System.out.println(f2.canExecute());
        System.out.println(f2.getAbsolutePath());
    }
}