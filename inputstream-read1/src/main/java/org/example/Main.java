package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            String s = readAsString(input);
            System.out.println(s);
        }
    }

    private static String readAsString(InputStream in) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = in.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}