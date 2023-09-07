package org.example.observer;

public interface ProductObserver {
    void onPublished(Product product);
    void onPriceChanged(Product product);
}
