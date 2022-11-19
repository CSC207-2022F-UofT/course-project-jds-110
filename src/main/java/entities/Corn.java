package entities;

public class Corn extends Crop implements Yieldable {
    private static final String name = "Corn";
    private static final int value = 5;

    public Product getYield() {
        return new CornCob();
    }

    public int getDaysToYield() {
        return 2;
    }
}
