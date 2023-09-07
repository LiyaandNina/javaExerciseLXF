package org.example.node;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children(Node node) {
        return List.of();
    }

    @Override
    public String toXml() {
        return this.text;
    }
}
