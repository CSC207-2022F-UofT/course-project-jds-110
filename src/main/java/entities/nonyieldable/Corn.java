package entities.nonyieldable;

import entities.Crop;

public class Corn extends Crop {
    private static final String name = "corn";
    private static final String yield = "corncob";
    private static final int value = 5;
    private static final int daysToYield = 2;

    public Corn(){
        super(name, yield, value, daysToYield);
    }
}
