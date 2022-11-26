package Entities;

public class Cow extends Animal {
    private static final String name = "Cow(s)";
    private static final String yield = "Bottle(s) of Milk";
    private static final int value = 30;
    private static final int daysToYield = 1;

    public Cow(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
