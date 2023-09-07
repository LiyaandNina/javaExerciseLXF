package com.iwans.stringtesttwo;

public class TestExceptionTwo {
    public static void main(String[] args) {
        try {
            process1();
        }catch(Exception e){
            System.out.println("catched");
            e.printStackTrace();
        }finally {
            System.out.println("final");
        }
    }

    static void process1(){
        try{
            process2();
        }catch (NullPointerException e){
            throw new IllegalArgumentException(e);
        }
    }

    static void process2(){
        throw new NullPointerException();
    }
}
