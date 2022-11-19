package entities;

public class Sheep extends Animal implements Yieldable {
    private static final String name = "Sheep";
    private static final int value = 100;

    public Product getYield() {
        return new Wool();
    }

    public int getDaysToYield() {
        return 30;
    }
}
