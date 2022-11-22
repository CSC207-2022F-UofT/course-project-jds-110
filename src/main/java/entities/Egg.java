package entities;

public class Egg extends Product implements Yieldable {
    private static final String name = "Egg(s)";
    private static final int value = 1;

    public Egg(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
