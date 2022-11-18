package SaveStateUseCase;


import Entities.Inventory;
import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.CheckProgressBoundary;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class State {
    private String name;

    public String getName() { return name; }

    public void initializeGame() throws IOException {
        /* ask the user to enter a name for the farm */
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a name for your farm: ");
        name = bfn.readLine();
    }

    public void saveGame() throws IOException {
        FileOutputStream fileWriter = new FileOutputStream(name + ".ser", false);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        out.writeObject(name);
        out.writeObject(InventoryManager.getMyInventory());
        out.writeObject(PlotManager.getMyPlots());
        out.close();
        fileWriter.close();
        System.out.println("Game saved in" + name + ".ser");
    }

    public void loadGame(String s) throws IOException, ClassNotFoundException {
        FileInputStream fileReader = new FileInputStream(s + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileReader);

        Object o = in.readObject();
        while (o != null) {
            if (o instanceof String) {
                name = (String) o;
            } else if (o instanceof Inventory) {
                InventoryManager.setMyInventory((Inventory) o);
            } else if (o instanceof ArrayList) {
                PlotManager.setMyPlots((ArrayList<Plot>) o);
            }
            o = in.readObject();
        }
    }

    /**
     * gameProgress() method calls InventoryManager and PlotManager to fetch user's
     * inventory, plot and money information.
     * Sends information through the UseCaseInteractorBoundary output.
     */
    public static void gameProgress () {
        HashMap<Product, Integer> inventory = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        CheckProgressBoundary.boundaryOutput(inventory, plots, money);
    }
}