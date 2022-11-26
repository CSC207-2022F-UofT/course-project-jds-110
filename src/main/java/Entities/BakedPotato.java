package entities;

public class BakedPotato extends Product implements Yieldable {
    private static final String name = "Baked Potato(es)";
    private static final int value = 2;

    public BakedPotato(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
