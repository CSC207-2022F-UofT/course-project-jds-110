package Entities;

public class Tomato extends Crop{
    private static final String name = "tomato";
    private static final String yield = "Ripe Tomato(es)";
    private static final int value = 3;
    private static final int daysToYield = 30;


    public Tomato(){
        super(name, yield, value, daysToYield);
    }
}
