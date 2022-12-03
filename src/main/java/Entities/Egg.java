package Entities;

public class Egg extends Product implements Yieldable {
    private static final String name = "egg";

    private static final int value = 1;
    private static final String yield = "";

    private static final int daysToYield = 0;

    public Egg() {

        super(name, yield, value, daysToYield);
    }
}
