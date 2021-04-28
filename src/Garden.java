package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Garden {
    
    private static final int CAPACITY = 12;
    private static List<Plant> garden = new ArrayList<Plant>(CAPACITY);
    private static int countInGarden = 0;

    public static void addPlant(Scanner scanner){

        if(!isFull()){

            System.out.println("Add a regular plant[1] or tomato[2]?");
            String choice = scanner.nextLine();            
            
            String plantName = Helpers.input(scanner, "Write the plant name");
            String plantType = Helpers.input(scanner, "Write the plant type");
            String datePlanted = Helpers.input(scanner, "Enter the date planted [YYYY-MM-DD]");
            int plantSpacing = UIUtility.validateIntInput(Helpers.input(scanner, "Enter the spacing"), 24, scanner);
            String aliveString = Helpers.input(scanner, "Is the plant alive [1-yes, 2-No]");
            boolean alive = aliveString.equals("1") || aliveString.trim().toLowerCase().charAt(0) == 'y' ? true : false;

            Plant plant = null;
            if (choice.equals("2")) {
                int fruitSize = UIUtility.validateIntInput(Helpers.input(scanner, "Enter the size in ounces"), 10, scanner);
                String color = Helpers.input(scanner, "Enter the color");
                plant = new Tomato(plantName, plantType, datePlanted, plantSpacing, alive, fruitSize, color);
            }
            else{
                plant = new Plant(plantName, plantType, datePlanted, plantSpacing, alive);
            }     
            garden.add(plant);    
            System.out.println("Plant added.");
        }
        else{
            System.out.println("Garden is full.");
        }
    }
 
    public static void removePlant(Scanner scanner){
        Plant plant = Helpers.selectPlantFromGarden(scanner);
        System.out.println("Removed\n" + plant.toString());
        garden.remove(plant);
    }

    public static void updatePlant(Scanner scanner){

        Plant plant = Helpers.selectPlantFromGarden(scanner);
        Helpers.plantUpdateMenu(plant, scanner);
    }

    public static void seedData() {

        if (isFull() || getCountInGarden() != 0){
            System.out.println("The garden is too full for this testing method.");
        }        
        else{

            //Plant plant1 = new Plant(); // default
            Plant plant4 = new Tomato("Big Beef", "Fruit", "2021-05-20", 12, true, 12, "Red");
            Plant plant2 = new Plant("Basil", "Herb", "2021-04-20", 5, true);
            Plant plant3 = new Tomato();
            Plant plant5 = new Plant("Apple", "Fruit", "2019-09-20", 24, true);
            Plant plant6 = new Plant("Zucchini", "Squash", "2021-04-19", 10, true);
            Plant watermelon = new Plant("Watermelon", "Fruit", "2021-05-28", 12, true);
            Plant cilantro = new Plant("Cilantro", "Herb", "2021-04-28", 5, true);
            Plant mint = new Plant("Mint", "Herb", "2021-04-30", 5, true);
            Plant jalapeno = new Plant("Jalapeno", "Pepper", "2021-06-01", 6, true);
            Plant heirloom = new Tomato("Heirloom Tomatoes", "Fruit", "2021-05-13", 8, true, 5, "Red, Green, Yellow");
            Plant cherryTom = new Tomato("Cherry Tomatoes", "Fruit", "2021-05-13", 8, true, 1, "Red");
    
            //addPlant(plant1);
            garden.add(plant2);
            garden.add(plant3);
            garden.add(plant4);
            garden.add(plant5);
            garden.add(plant6);
            garden.add(watermelon);
            garden.add(cilantro);
            garden.add(mint);
            garden.add(jalapeno);
            garden.add(heirloom);
            garden.add(cherryTom);
        
            
            System.out.println("" + getCountInGarden() + " plants added.");
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

    public static int getCountInGarden(){
        countInGarden = garden.size();
        return countInGarden;
    }

    public static boolean isFull(){
        return (getCountInGarden() == CAPACITY ? true : false);
    }

    public static List<Plant> getGarden(){
        return garden;
    }

    
}
