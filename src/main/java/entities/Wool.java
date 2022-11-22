package entities;

public class Wool extends Product implements Yieldable {
    private static final String name = "Wool";
    private static final int value = 12;

    public Wool(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
