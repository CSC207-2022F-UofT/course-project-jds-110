package random_events_use_case;

public class RandomEventsController {

    public String run_probabilities(){
        RandomEvents r = new RandomEvents();
        r.caluclate_events();
        String event = r.getEvent();
        if (event.equals("")) {
            return ("NO EVENT HAPPENED");
        } else {
            return ("EVENT!!! You were struck by " + event + " . Check up on your Inventory and Plots to see how you may have been affected");
        }


    }
}
