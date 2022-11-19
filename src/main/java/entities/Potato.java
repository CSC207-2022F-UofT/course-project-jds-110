package entities;

public class Potato implements Yieldable {
    private static final String name = "Potato(es)";
    private static final int value = 7;

    public Product getYield() {
        return new BakedPotato();
    }

    public int getDaysToYield() {
        return 10;
    }
}