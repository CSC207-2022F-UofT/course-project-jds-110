package raising_crops_and_animals_use_case;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Farmer {
    public static void place_animals(Animal animal, Plot plot) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which plot do you want to place your animal?");
        int num = Integer.parseInt(bfn.readLine());
        boolean a = PlotManager.place(animal, num);
        if (a){
            System.out.println("You have placed your animal!");
        }
        else{
            System.out.println("Sorry, your plot is full.");
        }
    }

    public static void place_crops(Crop crop, Plot plot) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which plot do you want to place your crop?");
        int num = Integer.parseInt(bfn.readLine());
        boolean b = PlotManager.place(crop, num);
        if (b){
            System.out.println("You have placed your crop!");
        }
        else{
            System.out.println("Sorry, your plot is full.");
        }
    }


}