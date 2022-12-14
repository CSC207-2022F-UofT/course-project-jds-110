package entities;

import java.util.HashMap;

public class RandomEventsProbabilities {

    // meteor
    // higher-rent
    // thief
    // bugs
    private final HashMap<String, Double> probabilities = new HashMap<>();

    public RandomEventsProbabilities(){
        // setup
        probabilities.put("meteor", 0.01);
        probabilities.put("thief", 0.20);
        probabilities.put("higher-rent", 0.10);
        probabilities.put("bugs", 0.05);
    }

    public HashMap<String, Double> getProbabilities() {
        return probabilities;
    }
}
