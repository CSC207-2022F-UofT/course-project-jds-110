package Entities;

public class Chicken extends Animal {
    private static final String name = "chicken";
    private static final String yield = "egg";
    private static final int value = 10;
    private static final int daysToYield = 7;

    public Chicken() {
        super(name, yield, value, daysToYield);
    }
}
