package Entities;

public class Egg extends Product implements Yieldable {
    private static final String name = "Egg(s)";


    private static final int value = 1;
    private static final String yield = "Chicken";

    private static final int daysToYield = 5;

    public Egg() {

        super(name, yield, value, daysToYield);
    }
}
