package Entities;

public class BakedPotato extends Product implements Yieldable {
    private static final String name = "Baked Potato(es)";
    private static final int value = 2;

    public BakedPotato(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
