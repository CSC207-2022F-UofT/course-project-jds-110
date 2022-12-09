package entities;

public abstract class Crop extends Product {
    public Crop(String name, String yield, int value, int daysToYield) {
        super(name, yield, value, daysToYield);
    }
}
