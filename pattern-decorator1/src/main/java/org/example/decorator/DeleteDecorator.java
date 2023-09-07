package org.example.decorator;

import org.example.node.Node;

public class DeleteDecorator extends Decorator {

    public DeleteDecorator(Node target) {
        super(target);
    }

    @Override
    public void setText(String text) {
        this.node.setText("<del>" + this.node.getText() + "</del>");
    }

}
