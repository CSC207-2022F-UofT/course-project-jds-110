package entities;

public abstract class Product {
    private String name;

    private StringBuilder emoji;
    private String yield;
    private int value;
    private int daysToYield;

    public Product(String name, StringBuilder emoji, String yield, int value, int daysToYield){
        this.name = name;
        this.emoji = emoji;
        this.value = value;
        this.yield = yield;
        this.daysToYield = daysToYield;
    }

    public String getName() {return name;}

    public StringBuilder getEmoji() {return emoji;}

    public String getYield() {
        return yield;
    }

    public int getDaysToYield() {
        return daysToYield;
    }

    public int getValue() {
        return value;
    }

}
