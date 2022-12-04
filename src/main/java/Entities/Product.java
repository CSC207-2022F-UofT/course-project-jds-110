package Entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;
    private String yield;
    private int value;
    private int daysToYield;

    public Product(String name, String yield, int value, int daysToYield){
        this.name = name;
        this.yield = yield;
        this.value = value;
        this.daysToYield = daysToYield;
    }
    public String getName() {return name;}

    public String getYield() {
        return yield;
    }

    public int getDaysToYield() {
        return daysToYield;
    }

    public int getValue() {
        return value;
    }

    public void daysToYield() {
    }
}
