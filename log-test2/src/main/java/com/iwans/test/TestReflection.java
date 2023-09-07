package com.iwans.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

public class TestReflection {

    static final Log log = LogFactory.getLog(TestReflection.class);

    public static void main(String[] args) {
//        Class cls = String.class;
//        String s = "Hello";
//        Class cls2 = s.getClass();
//        try {
//            Class cls3 = Class.forName("java.lang.String");
//        } catch (ClassNotFoundException e) {
//            log.info("Info: ", e);
//        }
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }

    static void printClassInfo(Class cls){
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if(cls.getPackage() != null) {
            System.out.println("Class package: " + cls.getPackage());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("=================================");
    }
}
