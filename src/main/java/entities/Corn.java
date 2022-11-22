package entities;

public class Corn extends Crop {
    private static final String name = "Corn";
    private static final StringBuilder emoji = new StringBuilder("\uD83C\uDF3D");
    private static final String yield = "CornCob(s)";
    private static final int value = 5;
    private static final int daysToYield = 2;

    public Corn(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
