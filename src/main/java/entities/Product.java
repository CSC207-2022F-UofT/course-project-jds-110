package entities;

public abstract class Product {
    private static String name;
    private static String yield;
    private static int value;
    private static int daysToYield;

    public String getName() {return name;}

    public Product getYield() {
        return null;
    }

    public int getDaysToYield() {
        return daysToYield;
    }

    public int getValue() {
        return value;
    }

}
