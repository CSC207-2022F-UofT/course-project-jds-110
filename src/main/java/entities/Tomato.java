package entities;

public class Tomato extends Crop {
    private static final String name = "Tomato(es)";
    private static final String yield = "Ripe Tomato(es)";
    private static final int value = 3;
    private static final int daysToYield = 30;

    @Override
    public Product getYield() {
        return new RipeTomato();
    }
}
