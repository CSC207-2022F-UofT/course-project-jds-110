package Entities;

public abstract class Product {
    private static String name;

    private static StringBuilder emoji;
    private static String yield;
    private static int value;
    private static int daysToYield;

    public String getName() {return name;}

    public StringBuilder getEmoji() {return emoji;}

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
