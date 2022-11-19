package entities;

public class Chicken extends Animal implements Yieldable {
    private static final String name = " Chicken(s)";
    private static final int value = 10;

    public Product getYield() {
        return new Egg();
    }

    public int getDaysToYield() {
        return 7;
    }
}
