package com.iwans.stringtesttwo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestException {
    public static void main(String[] args) {
        byte[] s = TestException.toGBK("中文");
        System.out.println(Arrays.toString(s));
    }

    public static byte[] toGBK(String s){
        try{
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return s.getBytes();
        }
    }
}
