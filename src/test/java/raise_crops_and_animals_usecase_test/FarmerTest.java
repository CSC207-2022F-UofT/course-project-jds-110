package raise_crops_and_animals_usecase_test;

import Entities.Animal;
import Entities.Crop;
import Entities.Plot;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.jupiter.api.Assertions;
import raising_crops_and_animals_use_case.Farmer;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import save_state_use_case.State;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static raising_crops_and_animals_use_case.Farmer.place_animals;

public class FarmerTest {
    @BeforeEach
    public void setup() {
        Plot plot1;
        Animal sheep;
        Crop corn;
    }

    @AfterEach
    public void teardown() {
    }

    @Test
    public void testPlaceAnimal() {
        Animal Chicken;
        Plot plot1;
        Assertions.assertNull(place_animals(sheep, plot1));
    }

    @Test
    public void testPlaceCrop() {
        Crop corn;
        Plot plot1;
        Assertions.assertNull(place_animals(sheep, plot1));
    }


}
