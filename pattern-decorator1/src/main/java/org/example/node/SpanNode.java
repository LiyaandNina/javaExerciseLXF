package org.example.node;

public class SpanNode implements Node {

    private String text;

    public SpanNode(String text) {
        this.text = text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<span>" + this.text + "</span>";
    }
}
