package EndGameConditions_UseCase;

import Use_Case_Interactors.InventoryManager;

/**
    This class is called by nextDay, to determine whether certain win/lose conditions are met
 */
 
public class EndgameConditions {
    /**
    uses the checkers to return whether the game has ended.
    @return a string that represents whether you won, lose or nothing changed, as well as how you won
     */

    public static String endGame(){
        if (checkWinMoney()){
            return "You have reached the required amount of money needed to win. Currently you have : "+
                    InventoryManager.getMyInventoryMoney() +" amount";
        }
        else if (checkWinSpecies()){
            return "You have acquired all of the different species of crops and animals required to win." +
                    "Currently you have : " + InventoryManager.getMyInventoryItems().size()     + " species";
        }
        if (checkLose()){
            return "You have lost the game by going below the required threshold of 100. Currently you have : " +
                    InventoryManager.getMyInventoryMoney() + "amount";
        }
        else {
            // if this method returns "game not over", this nextDay will know that the game has not ended
            return "game not over";
        }
    }


    /**
    checker to see if the win condition for gaining the required amount of money is reached
    return true if it has been reached
    else return false
     @return True or False, for whether you met the win condition
     */
    public static boolean checkWinMoney() {
        return InventoryManager.getMyInventoryMoney() > 1500;
    }

    /**
    check to see if the win condition for gaining the required amount of species of crops and animals is reached
    return true if it has been reached
    else return false
     @return True or False, for whether you met the win condition
     */
    public static boolean checkWinSpecies(){
        return InventoryManager.getMyInventoryItems().size() >= 2;
    }

    /**
    check to see if the loss condition for not having enough money is reached
    return true if money is below the required limit
    else return false
     @return True or False, for whether you met the loss condition
    */
    public static boolean checkLose(){
        return InventoryManager.getMyInventoryMoney() < InventoryManager.getRent();
    }

}
