package org.example;

import org.example.brand.BossCar;
import org.example.engine.BossEngine;

public class Main {
    public static void main(String[] args) {
        Car car = new BossCar(new BossEngine());
        car.drive();
    }
}