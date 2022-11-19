package entities;

public interface Yieldable {
    /* Something is able to produce yields */
    Product getYield();
    int getDaysToYield();
}
