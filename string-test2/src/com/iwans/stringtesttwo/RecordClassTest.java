package com.iwans.stringtesttwo;

import java.math.BigInteger;
import java.util.HexFormat;

public class RecordClassTest {
    public static void main(String[] args) {
//        Point p = Point.of(123, 456);
//        System.out.println(p.x());
//        System.out.println(p.y());
//        System.out.println(p);
//        Point p2 = new Point(123, 456);
//        System.out.println(p2.equals(p));
//        System.out.println(p2.hashCode());
////        Point p3 = new Point(123, -456);
//        BigInteger n = new BigInteger("999999").pow(99);
//        float f = n.floatValue();
//        System.out.println(f);
//        double x = Math.pow(2, 12);
//        double sqrt = Math.sqrt(4);
//        double exp = Math.exp(12);
        HexFormat hf = HexFormat.of();
        String res = hf.formatHex("Heloo".getBytes());
        HexFormat hf2 = HexFormat.of().withDelimiter("").withPrefix("0x").withUpperCase();
        String res2 = hf2.formatHex("Hello".getBytes());
        System.out.println(res);
        System.out.println(res2);
    }
}

record Point(int x, int y){
    public Point {
        if(x < 0 || y < 0){
            throw new IllegalArgumentException();
        }
    }

    public static Point of(){
        return new Point(0, 0);
    }

    public static Point of(int x, int y){
        return new Point(x, y);
    }
}
