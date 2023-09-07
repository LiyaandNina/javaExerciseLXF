package org.example.brand;

import org.example.Car;
import org.example.engine.Engine;

import java.sql.Ref;

public abstract class RefinedCar extends Car {

    public RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    public abstract String getBrand();
}
