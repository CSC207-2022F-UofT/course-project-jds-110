package entities.nonyieldable;

public class Sheep extends Animal {
    private static final String name = "sheep";
    private static final String yield = "Wool";
    private static final int value = 100;
    private static final int daysToYield = 30;

    public Sheep() {
        super(name, yield, value, daysToYield);
    }
}
