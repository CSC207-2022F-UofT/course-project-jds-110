package UI;
import CheckProgressUseCase.CheckProgressController;
import Entities.Chicken;
import Entities.Corn;
import Entities.Product;
import InterctWithMarketUseCase.ShopperController;
import save_state_use_case.StateController;

import java.io.IOException;
import java.util.Scanner;

public class BasicUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello and Welcome to ..... 'Farmvile but worse' ");



        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Please Enter your name: ");
        String name = reader.next(); // Scans the next token of the input as an int.
        //once finished
        System.out.println(name);


        /// Load/new
        loadOrNew(name, reader);

        /// show progress immediatly
        progress(reader);
        /// show progress, farm, shop, next day
        System.out.println("Great, looks like you're all set up, have fun playing :)");

        boolean running = true;
        while (running){
            System.out.println("Available actions: 'shop', 'go to next day', 'show_progress', 'farm', ENDGAME!");
            System.out.println("What would you like to do next:");
            String currAction = reader.next();

            if (currAction.equals("ENDGAME")){
                running = false;
            } else if (currAction.equals("shop")){
                shop(reader);
            } else if (currAction.equals("go to next day")){
                next_day(reader);
            } else if (currAction.equals("farm")) {
                farm(reader);
            } else if (currAction.equals("show_progress")){
                progress(reader);
            } else if (currAction.equals("save")){
                save(reader);
            }
            // check what the action is and make the relvent call
        }


        reader.close();

    }
    public static void loadOrNew(String name, Scanner reader) throws IOException, ClassNotFoundException {
        System.out.println("Welcome " + name + "! Would you like to load a previous game, or start afresh:");
        String loadOrNew = reader.next();
        if (loadOrNew.equals("save")){
            System.out.println("You chose to save");
            StateController.saveGame();
            // call controller
        } else if (loadOrNew.equals("new")) {
            System.out.println("You chose to start new game");
            StateController.initializeGame();
            // call controller
        } else if (loadOrNew.equals("load")){
            System.out.println("You chose to load");
            StateController.loadGame();
            // call controller
        } else{
            System.out.println("Invalid Input");
        }

    }

    public static void save(Scanner reader) throws IOException {
        System.out.println("YOu chose to save");
        StateController.saveGame();
    }

    public static void shop(Scanner reader){
        System.out.println("What do you want to do:");
        String subAction = reader.next();
        System.out.println("Pick an item");
        String item = reader.next();
        System.out.println("Pick a quantity");
        int quant = Integer.parseInt(reader.next());
        if (subAction.equals("buy")){
            if (item.equals("corn")) {
                Product a = new Corn();
                ShopperController.InputBuy_from_market(a, quant);
            } else if (item.equals("chicken")){
                Product b = new Chicken();
                ShopperController.InputBuy_from_market(b, quant);
            } else {
                System.out.println("Thats not a valid product :(");
            }
        }

    }
    public static void farm(Scanner reader){
    }
    public static void progress(Scanner reader){
        CheckProgressController.getProgress();
    }
    public static void next_day(Scanner reader){
    }
}
