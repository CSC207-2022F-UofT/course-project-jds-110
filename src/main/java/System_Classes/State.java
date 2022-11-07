package System_Classes;

import Action_Classes.InventoryManager;
import Action_Classes.PlotManager;
import Data_Classes.Inventory;
import Data_Classes.Plot;
import Data_Classes.Products;

import java.io.*;
import java.util.ArrayList;

public class State {
    private String name;
    private InventoryManager invMan;
    private PlotManager plotMan;

    public void initializeGame() throws IOException {
        invMan = new InventoryManager();
        plotMan = new PlotManager();

        /* ask the user to enter a name for the farm */
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a name for your farm: ");
        name = bfn.readLine();

        /* to be continued... */
    }

    public void saveGame() throws IOException {
        ArrayList<Object> data = new ArrayList<>();
        data.add(name);
        data.add(invMan);
        data.add(plotMan);
        /* may be changed later */

        FileOutputStream fileWriter = new FileOutputStream(name + ".ser", false);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        out.writeObject(data);
        out.close();
        fileWriter.close();
        System.out.println("Game saved in" + name + ".ser");
    }

    public void loadGame(String s) throws IOException, ClassNotFoundException {
        ArrayList<Object> arr;
        FileInputStream fileReader = new FileInputStream(s + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileReader);
        arr = (ArrayList<Object>) in.readObject();
        /* may be changed later */

        for (Object o : arr) {
            if (o instanceof String) {
                name = (String) o;
            } else if (o instanceof InventoryManager) {
                invMan = (InventoryManager) o;
            } else if (o instanceof PlotManager) {
                plotMan = (PlotManager) o;
            }
        }
    }

    public void gameProgress() {

    }
}