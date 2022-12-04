package nextday_use_case;

public class NextDayController {
    /* This method accesses the Use Case layer to call methods in NextDay class in order
     */
    public static void goToNextDay() {
      /* Use nextDayEndgame to check whether the game is over or not.
      If it's not over, then products in plots increment progress,
      money is removed from Inventory to pay for rent, and some random events occur as well.
      If the game is over, then print out the message from nextDayEndgame.
      */
        if (!NextDay.nextDayEndgame().equals("game not over")){
            NextDay.nextDayPlots();
            NextDay.nextDayInventory();
            NextDay.nextDayRandomEvents();
        } else {
            System.out.println(NextDay.nextDayEndgame());
        }
    }
}