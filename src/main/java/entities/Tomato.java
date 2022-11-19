package entities;

public class Tomato implements Yieldable {
    private static final String name = "Tomato(es)";
    private static final int value = 3;

    public Product getYield() {
        return new RipeTomato();
    }

    public int getDaysToYield() {
        return 30;
    }
}
