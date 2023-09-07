package org.example.decorator;

import org.example.node.Node;

public abstract class Decorator implements Node {
    protected final Node node;

    protected Decorator(Node node) {
        this.node = node;
    }

    @Override
    public String getText() {
        return this.node.getText();
    }

}
