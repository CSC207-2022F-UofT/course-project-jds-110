package SaveStateUseCase;


import entities.Inventory;
import entities.Plot;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

import java.io.*;
import java.util.ArrayList;

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

}