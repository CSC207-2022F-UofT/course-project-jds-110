package nextday_use_case;

public class NextDayController {
    public static void goToNextDay() {
        /* This method accesses the Use Case layer
        to call methods in NextDay class in the following order
         */
        NextDay.nextDayPlots();
        NextDay.nextDayInventory();
        NextDay.nextDayRandomEvents();
        NextDay.nextDayEndgame();
    }
}