package System_Classes;
import java.util.ArrayList;

import Data_Classes.Inventory;

public class EndgameConditions extends Inventory {

    //uses the checkers to return whether the game has ended.
    public String endGame(){
        if (checkWinMoney() == true){
            return "You have reached the required amount of money needed to win of 1500 with currently: "+
                    this.getMyMoney() +" amount";
        }
        else if (checkWinSpecies() == true){
            return "You have acquired all of the different species of crops and animals required to win with " +
                    "currently: " + this.getMyItems().size() + " species";
        }
        if (checkLose() == true){
            return "You have lost the game by going below the required threshhold of 100, with currently: " +
                    this.getMyMoney() + "amount";
            }
        else {
            // if this method returns "game not over", this nextDay will know that the game has not ended
            return "game not over";
        }
    }
    /*checker to see if the win condition for gaining the required amount of money is reached
    return true if it has been reached
    else return false
     */
    public boolean checkWinMoney() {
        if (this.getMyMoney() > 1500){
            return true;
        }
        else{
            return false;
        }}

    /*check to see if the win condition for gaining the required amount of species of crops and animals is reached
    return true if it has been reached
    else return false
     */
    public boolean checkWinSpecies(){
        if (this.getMyItems().size() == 6){
            return true;
        }
        else{
            return false;
        }
    }

    /*check to see if the lose condition for not having enough money is reached
    return true if money is below the required limit
    else return false
    */
    public boolean checkLose(){
        if (this.getMyMoney() <= 100){
            return true;
        }
        else{
            return false;
        }
    }


}
