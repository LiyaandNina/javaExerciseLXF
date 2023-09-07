package org.example.state;

public class BusyState implements State {
    @Override
    public String init() {
        return "I am busy now!";
    }

    @Override
    public String reply(String input) {
        return "Sorry, I am busy now!";
    }
}
