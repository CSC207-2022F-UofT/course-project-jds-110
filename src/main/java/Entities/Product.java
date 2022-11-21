package Entities;
import java.io.Serializable;

public abstract class Product implements Serializable {
    private static String name;
    private static String yield;
    private static int value;
    private static int daysToYield;

    public String getName() {return name;}

    public String getYield() {return yield;}

    public int getDaysToYield() {
        return daysToYield;
    }

    public int getValue() {
        return value;
    }

}
