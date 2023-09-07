package org.example.node;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ElementNode implements Node {
    private String name;
    private List<Node> chd = new ArrayList<>();

    public ElementNode(String name) {
        this.name = name;
    }

    @Override
    public Node add(Node node) {
        chd.add(node);
        return this;
    }

    @Override
    public List<Node> children(Node node) {
        return this.chd;
    }

    @Override
    public String toXml() {
        String start = "<" + this.name + ">\n";
        String end = "</" + this.name +">\n";
        StringJoiner sj = new StringJoiner("", start, end);
        chd.stream().forEach(node -> sj.add(node.toXml() + "\n"));
        return sj.toString();
    }
}
