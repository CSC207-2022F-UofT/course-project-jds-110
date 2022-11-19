package entities;

public class Cow extends Animal implements Yieldable {
    private static final String name = "Cow(s)";
    private static final int value = 30;

    public Product getYield() {
        return new Milk();
    }

    public int getDaysToYield() {
        return 1;
    }
}
