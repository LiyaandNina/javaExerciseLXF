package com.iwans.stringtesttwo;

import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomTest {
    public static void main(String[] args) {
//        SecureRandom sr = new SecureRandom();
//        int x = sr.nextInt(5000000);
//        System.out.println(x);
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Normal");
            sr = new SecureRandom();
        }
        byte[] b = new byte[16];
        sr.nextBytes(b);
        System.out.println(Arrays.toString(b));
    }
}
