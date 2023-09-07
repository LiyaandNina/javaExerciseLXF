package org.example.chain;

public class CEOHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        return !request.getName().equalsIgnoreCase("Alice");
    }
}
