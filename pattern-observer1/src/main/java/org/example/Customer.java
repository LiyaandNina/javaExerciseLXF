package org.example;

import org.example.observer.Product;
import org.example.observer.ProductObserver;

public class Customer implements ProductObserver {
    @Override
    public void onPublished(Product product) {
        System.out.println("[Customer] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        System.out.println("[Customer] on product price changed: " + product);
    }
}
