package entities;

public class CornCob extends Product implements Yieldable {
    private static final String name = "CornCob";
    private static final int value = 2;

    public CornCob(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
