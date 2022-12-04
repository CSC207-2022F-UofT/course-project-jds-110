package Entities;

public class CornCob extends Product implements Yieldable {
    private static final String name = "CornCob";

    private static final int value = 10;
    private static final String yield = "";

    private static final int daysToYield = 0;

    public CornCob() {

        super(name, yield, value, daysToYield);
    }
}
