package nextday_use_case;

/** This controller accesses the Use Case layer to call methods in NextDay class.
 */
public class NextDayController {
    /** Use nextDayEndgame to check whether the game is over or not.
     If it's not over, then products in plots increment progress,
     money is removed from Inventory to pay for rent, and some random events may occur as well.
     Some notifications will be printed out to inform the player.
     If the game is over, then print out the message from nextDayEndgame.
     */
    public static String goToNextDay() {
        String state = NextDay.nextDayEndgame();
        if (state.equals("game not over")) {
            NextDay.nextDayInventory();
            String plotInfo = NextDay.nextDayPlots();
            String eventInfo = NextDay.nextDayRandomEvents();
            if (!plotInfo.equals("")) {
                return "NOW IS THE NEXT DAY!\n\n" + plotInfo + "\n\n" + eventInfo;
            } else {
                return "NOW IS THE NEXT DAY!\n\n" + eventInfo + "\n\n" + plotInfo;
            }
        } else { return state; }
    }
}