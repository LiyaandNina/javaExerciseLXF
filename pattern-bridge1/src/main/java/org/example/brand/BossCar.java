package org.example.brand;

import org.example.engine.Engine;

public class BossCar extends RefinedCar {

    public BossCar(Engine engine) {
        super(engine);
    }

    public String getBrand() {
        return "Boss";
    }
}
