package entities;

public class Sheep extends Animal {
    private static final String name = "Sheep";
    private static final String yield = "Wool";
    private static final int value = 100;
    private static final int daysToYield = 30;

    @Override
    public Product getYield() {
        return new Wool();
    }
}
