package org.example.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements ProductObservable {
    private List<ProductObserver> productObserverList = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    public void addObserver(ProductObserver productObserver) {
        productObserverList.add(productObserver);
    }

    public void removeObserver(ProductObserver productObserver) {
        productObserverList.remove(productObserver);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        productMap.put(p.getName(), p);
        for(ProductObserver productObserver: productObserverList) {
            new Thread(() -> {
                productObserver.onPublished(p);
            }).start();
        }
    }

    public void setProductPrice(String name, double price) {
        Product p = productMap.get(name);
        p.setPrice(price);
        for (ProductObserver productObserver: productObserverList) {
            new Thread(() -> {
                productObserver.onPriceChanged(p);
            }).start();
        }
    }
}
