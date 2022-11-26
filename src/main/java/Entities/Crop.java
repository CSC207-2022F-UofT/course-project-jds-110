package entities;

public abstract class Crop extends Product {
    public Crop(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
