package entities;

public class Tomato extends Crop {
    private static final String name = "Tomato(es)";
    private static final String yield = "Ripe Tomato(es)";
    private static final StringBuilder emoji = new StringBuilder("\uD83C\uDF45");
    private static final int value = 3;
    private static final int daysToYield = 30;


    public Tomato(){
        super(name, emoji, yield, value, daysToYield);
    }
}
