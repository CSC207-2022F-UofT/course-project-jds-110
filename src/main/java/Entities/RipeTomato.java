package Entities;

public class RipeTomato extends Product implements Yieldable {
    private static final String name = "ripetomato";

    private static final int value = 1;
    private static final String yield = "";

    private static final int daysToYield = 0;

    public RipeTomato() {

        super(name, yield, value, daysToYield);
    }

}
