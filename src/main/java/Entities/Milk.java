package entities;

public class Milk extends Product implements Yieldable {
    private static final String name = "Bottle(s) of Milk";
    private static final int value = 3;

    public Milk(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
