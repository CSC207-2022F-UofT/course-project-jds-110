package entities;

public class Chicken extends Animal {
    private static final String name = " Chicken(s)";
    private static final String yield = "Egg(s)";
    private static final StringBuilder emoji = new StringBuilder("\uD83D\uDC13");
    private static final int value = 10;
    private static final int daysToYield = 7;

    public Chicken() {
        super(name, emoji, yield, value, daysToYield);
    }
}
