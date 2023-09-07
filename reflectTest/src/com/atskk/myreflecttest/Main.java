package com.atskk.myreflecttest;

public class Main {

    public static void main(String[] args) {
        Class cls1 = String.class;
        String str1 = "Hello";
        Class cls2 = str1.getClass();
        System.out.println(cls1.toString());
        System.out.println(cls2.toString());
        if(args.length == 0 ){
            System.out.println("No Hello");
        }else{
            Hello hello1 = new Hello();
        }
    }

}
