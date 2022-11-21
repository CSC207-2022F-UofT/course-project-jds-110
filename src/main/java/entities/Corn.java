package entities;

public class Corn extends Crop {
    private static final String name = "Corn";
    private static final String yield = "CornCob(s)";
    private static final int value = 5;
    private static final int daysToYield = 2;

    @Override
    public Product getYield() {
        return new CornCob();
    }
}
