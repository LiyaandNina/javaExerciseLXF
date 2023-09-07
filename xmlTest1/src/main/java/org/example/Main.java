package org.example;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStream input = Main.class.getResourceAsStream("/book.xml");
        XmlMapper mapper = new XmlMapper(new JacksonXmlModule());
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.id);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);
    }
}