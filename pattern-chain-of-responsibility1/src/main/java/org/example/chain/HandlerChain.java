package org.example.chain;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public Boolean process(Request request) throws RuntimeException {
        for (Handler handler: handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                System.out.println(
                        request + " " + (r ? "Approved By" : "Denied By") +handler.getClass().getSimpleName()
                );
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }
}
