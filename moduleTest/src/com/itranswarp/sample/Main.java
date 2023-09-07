package com.itranswarp.sample;

import javax.xml.XMLConstants;

public class Main {

    public static void main(String[] args) {
        Greeting hello = new Greeting();
        System.out.println(hello.hello(XMLConstants.XML_NS_PREFIX));
    }
}
