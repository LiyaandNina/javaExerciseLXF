package org.example;

import org.example.decorator.DeleteDecorator;
import org.example.node.Node;
import org.example.node.SpanNode;

public class Main {
    public static void main(String[] args) {
        Node node = new DeleteDecorator(new SpanNode("test node"));
        System.out.println(node.getText());
    }
}