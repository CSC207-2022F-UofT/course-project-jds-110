package entities;

public class Sheep extends Animal {
    private static final String name = "Sheep";
    private static final String yield = "Wool";
    private static final StringBuilder emoji = new StringBuilder("\uD83D\uDC11");
    private static final int value = 100;
    private static final int daysToYield = 30;

    public Sheep(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
