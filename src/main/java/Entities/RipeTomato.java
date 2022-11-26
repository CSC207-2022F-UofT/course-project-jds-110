package Entities;

public class RipeTomato extends Product implements Yieldable {
    private static final String name = "Ripe Tomato(es)";

    public RipeTomato(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
