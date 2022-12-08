package random_events_use_case;

import Entities.Inventory;
import Entities.RandomEventsProbabilities;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

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

        if (event.equals("bugs")){
            event_bugs();
        } else if (event.equals("meteor")){
            event_meteor();
        } else if (event.equals("thief")){
            event_thief();
        } else if (event.equals("higher-rent")){
            event_higher_rent();
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

    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
