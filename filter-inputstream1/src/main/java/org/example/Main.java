package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = "Hello, world!".getBytes("UTF-8");
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.print((char) n);
            }
            System.out.println("\nTotal read " + input.getBytesRead() + " Bytes.");
        }
    }
}

class CountInputStream extends FilterInputStream {
    private int count = 0;

    public CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    //int returns the value of the int in the next byte(0-255)
    @Override
    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count++;
        }
        return n;
    }

    @Override
    public int read(byte[] bytes, int off, int len) throws IOException {
        int n = in.read(bytes, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}