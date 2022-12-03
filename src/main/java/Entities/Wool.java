package Entities;

public class Wool extends Product implements Yieldable {
    private static final String name = "wool";
    private static final int value = 12;
    private static final String yield = "";
    private static final int daysToYield = 0;

    public Wool() {
        super(name, yield, value, daysToYield);
    }

}
