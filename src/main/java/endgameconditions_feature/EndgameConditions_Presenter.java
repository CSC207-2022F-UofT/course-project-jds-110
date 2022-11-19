package endgameconditions_feature;

import Use_Case_Interactors.InventoryManager;
import static endgameconditions_feature.EndgameConditions.*;

public class EndgameConditions_Presenter {

    //uses the checkers to return whether the game has ended.
    public static String endGame(){
        if (checkWinMoney() == true){
            return "You have reached the required amount of money needed to win of 1500. Currently you have : "+
                    InventoryManager.getMyInventoryMoney() +" amount";
        }
        else if (checkWinSpecies() == true){
            return "You have acquired all of the different species of crops and animals required to win." +
                    "Currently you have : " + InventoryManager.getMyInventoryItems().size()     + " species";
        }
        if (checkLose() == true){
            return "You have lost the game by going below the required threshold of 100. Currently you have : " +
                    InventoryManager.getMyInventoryMoney() + "amount";
        }
        else {
            // if this method returns "game not over", this nextDay will know that the game has not ended
            return "game not over";
        }
    }
}
