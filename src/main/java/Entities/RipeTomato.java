package entities;

public class RipeTomato extends Product implements Yieldable {
    private static final String name = "Ripe Tomato(es)";
    private static final int value = 5;

    public RipeTomato(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
