package Entities;

public class BakedPotato extends Product implements Yieldable {
    private static final String name = "bakedpotato";

    private static final int value = 10;
    private static final String yield = "";

    private static final int daysToYield = 0;

    public BakedPotato() {

        super(name, yield, value, daysToYield);
    }
}
