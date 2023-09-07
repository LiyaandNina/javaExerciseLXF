package org.example;

import org.example.observer.Product;
import org.example.observer.ProductObserver;

public class Admin implements ProductObserver {
    @Override
    public void onPublished(Product product) {
        System.out.println("[Admin] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        System.out.println("[Admin] on product price changed: " + product);
    }
}
