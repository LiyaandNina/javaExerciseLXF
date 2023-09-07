package org.example.node;

import java.util.List;

public interface Node {
    String toXml();

    Node add(Node node);

    List<Node> children(Node node);
}
