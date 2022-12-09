package entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private final String name;
    private final String yield;
    private final int value;
    private final int daysToYield;

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

}
