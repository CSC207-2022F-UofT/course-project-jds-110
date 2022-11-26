package entities;

public abstract class Animal extends Product {
    public Animal(String name, StringBuilder emoji, String yield, int value, int daysToYield) {
        super(name, emoji, yield, value, daysToYield);
    }
}
