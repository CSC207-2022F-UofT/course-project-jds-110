package endgameconditions_feature;

import Use_Case_Interactors.InventoryManager;

public class EndgameConditions {
    /*checker to see if the win condition for gaining the required amount of money is reached
    return true if it has been reached
    else return false
     */
    public static boolean checkWinMoney() {
        if (InventoryManager.getMyInventoryMoney() > 1500){
            return true;
        }
        else{
            return false;
        }}

    /*check to see if the win condition for gaining the required amount of species of crops and animals is reached
    return true if it has been reached
    else return false
     */
    public static boolean checkWinSpecies(){
        if (InventoryManager.getMyInventoryItems().size() == 6){
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
    public static boolean checkLose(){
        if (InventoryManager.getMyInventoryMoney() <= 100){
            return true;
        }
        else{
            return false;
        }
    }


}
