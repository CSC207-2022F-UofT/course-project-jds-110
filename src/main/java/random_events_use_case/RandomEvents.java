package random_events_use_case;

import entities.Inventory;
import entities.RandomEventsProbabilities;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomEvents {

    String event = "";

    public void caluclate_events(){

        HashMap<String, Double> probabilities = new RandomEventsProbabilities().getProbabilities();

        probabilities.put("meteor", 0.01);
        probabilities.put("thief", 0.20);
        probabilities.put("higher-rent", 0.10);
        probabilities.put("bugs", 0.05);


        for (String i: probabilities.keySet())
            if(new Random().nextDouble() < probabilities.get(i) ) {
                event = i;
                break;
            }

        switch (event) {
            case "bugs":
                event_bugs();
                break;
            case "meteor":
                event_meteor();
                break;
            case "thief":
                event_thief();
                break;
            case "higher-rent":
                event_higher_rent();
                break;
        }

    }

    private void event_higher_rent() {
        InventoryManager.increaseRent();
    }

    private void event_thief() {
        InventoryManager.removeMoney(200);
    }

    private void event_meteor() {
        InventoryManager.setMyInventory(new Inventory());
        InventoryManager.removeMoney(500);
        PlotManager.setMyPlots(new ArrayList<>());
    }

    private void event_bugs() {
        PlotManager.remove(0);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
