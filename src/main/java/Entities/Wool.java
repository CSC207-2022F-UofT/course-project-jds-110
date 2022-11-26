package Entities;

public class Wool extends Product implements Yieldable {
    private static final String name = "Wool";
    private static final int value = 12;

    public Wool(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
