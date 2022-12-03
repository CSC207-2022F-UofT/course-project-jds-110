package Entities;

public class Cow extends Animal {
    private static final String name = "cow";
    private static final String yield = "Bottle(s) of Milk";
    private static final int value = 30;
    private static final int daysToYield = 1;

    public Cow() {
        super(name, yield, value, daysToYield);
    }
}
