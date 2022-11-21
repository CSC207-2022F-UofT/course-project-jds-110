package entities;

public class Cow extends Animal {
    private static final String name = "Cow(s)";
    private static final String yield = "Bottle(s) of Milk";
    private static final int value = 30;
    private static final int daysToYield = 1;

    @Override
    public Product getYield() {
        return new Milk();
    }
}
