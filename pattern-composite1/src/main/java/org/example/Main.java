package org.example;

import org.example.node.CommentNode;
import org.example.node.ElementNode;
import org.example.node.Node;
import org.example.node.TextNode;

import java.util.Arrays;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        Node root = new ElementNode("school");
        root.add(new ElementNode("classA").add(new TextNode("Tom")).add(new TextNode("Alice")));
        root.add(new ElementNode("classB").add(new TextNode("Bob")).add(new TextNode("Grace"))
                                          .add(new CommentNode("comment...")));
        System.out.println(root.toXml());

        //===================================================
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sb = new StringBuilder(1024);
        StringJoiner sj = new StringJoiner(", ", " (", ") VALUES (?, ?, ?)");
        Arrays.stream(fields).forEach(s -> sj.add(s));
        sb.append("INSERT INTO ")
          .append(table)
          .append(sj);
        return sb.toString();
    }
}