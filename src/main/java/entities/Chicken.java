package entities;

public class Chicken extends Animal {
    private static final String name = " Chicken(s)";
    private static final String yield = "Egg(s)";
    private static final int value = 10;
    private static final int daysToYield = 7;

    @Override
    public Product getYield() {
        return new Egg();
    }
}
