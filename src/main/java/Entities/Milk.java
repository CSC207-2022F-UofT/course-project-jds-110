package Entities;

public class Milk extends Product implements Yieldable {
    private static final String name = "Milk";
    private static final int value = 3;
    private static final String yield = "";
    private static final int daysToYield = 0;

    public Milk() {

        super(name, yield, value, daysToYield);
    }
}
