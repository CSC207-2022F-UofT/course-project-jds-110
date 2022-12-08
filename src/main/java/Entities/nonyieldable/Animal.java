package entities.nonyieldable;

import entities.Product;

public abstract class Animal extends Product {
    public Animal(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
