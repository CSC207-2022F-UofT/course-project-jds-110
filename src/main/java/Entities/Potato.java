package Entities;

public class Potato extends Crop {

    private static final String name = "Potato(es)";
    private static final String yield = "Baked Potato(s)";
    private static final int value = 7;
    private static final int daysToYield = 10;

    public Potato() {
        super(name, yield, value, daysToYield);
    }
}