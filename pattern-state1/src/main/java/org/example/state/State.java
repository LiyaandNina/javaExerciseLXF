package org.example.state;

public interface State {
    String init();
    String reply(String input);
}
