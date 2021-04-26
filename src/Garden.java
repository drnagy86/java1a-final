package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Garden {
    
    private static final int CAPACITY = 12;
    private static List<Plant> garden = new ArrayList<Plant>(CAPACITY);

    public static void addPlant(Plant plant){
        garden.add(plant);
    }
 
    public static void removePlant(Plant plant){
        garden.remove(plant);
    }

    public static void updatePlant(Scanner scanner){

        viewPlantsAlpha();
        // string this up in the menu options so no typing is required.
        String plantString = Helpers.input(scanner, "Choose a plant");

        for (Plant plant : garden) {
            if (plant.getPlantName().equals(plantString)) {
                Helpers.plantUpdateMenu(plant, scanner);
                break;
            }
        }
    }

    

    public static void viewPlants(){
        //for loop that iterates and prints
        for (Plant plant : garden) {
            System.out.println(plant);
        }
    }

    public static void viewPlantsAlpha(){
        Collections.sort(garden);
        viewPlants();
    }

    public static void viewPlantsAlive(){
        Collections.sort(garden);
        for (Plant plant : garden) {
            if (plant.isAlive()) {
                System.out.println(plant);
            }
        }
    }

    public static void viewPlantsByDate(){
        Collections.sort(garden);
        // answer obtained from:
        // https://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        // on 2021-04-23

        garden.sort(Comparator.comparing(plant -> plant.getDatePlanted()));
        
        //My wrong attempt
        //Sorts by year correctly by not by month
        // for (int i = 0; i < garden.size()/2; i++) {
        //     for (int j = 1; j < garden.size(); j++) {

        //         int result = garden.get(i).getDatePlanted().compareTo((garden.get(j).getDatePlanted()));
                
        //         if (result < 0  ) {
        //             Plant temp = new Plant();

        //             temp = garden.get(i);

        //             garden.remove(garden.get(i));

        //             garden.add(temp);

        //         }
        //     }
        // }        

        viewPlants();

    }

    public static void viewPlantsBySpacing(){
        Collections.sort(garden);
        garden.sort(Comparator.comparing(plant -> plant.getPlantSpacing()));
        viewPlants();
    }

    // move a plant method, swap a plant method


    
}
