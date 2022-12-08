package Entities;

public class Potato extends Crop {

    private static final String name = "potato";
    private static final String yield = "bakedpotato";
    private static final int value = 7;
    private static final int daysToYield = 10;

    public Potato() {
        super(name, yield, value, daysToYield);
    }
}