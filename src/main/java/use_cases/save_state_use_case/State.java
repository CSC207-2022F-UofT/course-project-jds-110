package use_cases.save_state_use_case;

import entities.Inventory;
import entities.Plot;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class State {
    /** Initialize the game by constructing an inventory and assign it to InventoryManager.
     * Set the String s to be the name of the farm which is stored in the inventory.
     * Create two free plots for the player to begin.
     * Set up ProductStringDictionary in InventoryManager
     * */
    public static void initializeGame(String s){
        Inventory i = new Inventory();
        InventoryManager.setMyInventory(i);
        InventoryManager.setName(s);
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
        PlotManager.createNewPlot();
        InventoryManager.setupProductStringDictionary();
    }

    /** Save the game into a ser file.
     * Get the name of the farm stored in the inventory set it to be the name of the file
     * Save farm name and the money in the Inventory to the Farms.txt
     * so that LeaderBoard can check through.
     */
    public static void saveGame() throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/farms/";
        File file = new File(path + InventoryManager.getName() + ".ser");
        FileOutputStream fileWriter = new FileOutputStream(file, false);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(InventoryManager.getMyInventory());
        arr.add(PlotManager.getMyPlots());
        out.writeObject(arr);
        out.close();

        String path1 = System.getProperty("user.dir") + "/src/main/farms/Farms.txt";
        Path of = Path.of(path1);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(of, StandardCharsets.UTF_8));
        boolean newGame = true;
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(InventoryManager.getName())) {
                fileContent.set(i+1, String.valueOf(InventoryManager.getMyInventoryMoney()));
                newGame = false;
            }
        }
        if (newGame) {
            fileContent.add(InventoryManager.getName());
            fileContent.add(String.valueOf(InventoryManager.getMyInventoryMoney()));
        }
        Files.write(of, fileContent, StandardCharsets.UTF_8);
    }

    /** Load the file, which name is the input String.
     * Set up ProductStringDictionary in InventoryManager
     * */
    @SuppressWarnings("unchecked")
    public static void loadGame(String s) throws IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir") + "/src/main/farms/";
        File file = new File(path + s + ".ser");
        FileInputStream fileReader = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileReader);
        ArrayList<Object> data = (ArrayList<Object>) in.readObject();
        in.close();
        InventoryManager.setMyInventory((Inventory) data.get(0));
        PlotManager.setMyPlots((ArrayList<Plot>) data.get(1));
        InventoryManager.setupProductStringDictionary();
    }
}