package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Garden {
    private List<Plant> garden;

    public Garden(){
        // number limits the number in the list
        garden = new ArrayList<Plant>(12);

    }

    public void addPlant(Plant plant){
        garden.add(plant);
    }
 
    public void removePlant(Plant plant){
        garden.remove(plant);
    }

    public void updatePlant(Plant plant, Scanner scanner){
        // A nice little menu maybe? or at least update the relevant info
        //public static int showMenuOptions(String menuTitle, String prompt, String[] menuOptions, Scanner in)
        //    private String plantName;
        // private String plantType;
        // private LocalDate datePlanted;
        // private int plantSpacing;
        // private boolean alive;

        String[] menuOptions = {
            "Plant Name",
            "Plant Type",
            "Date Planted",
            "Plant Spacing",
            "Is alive?"
        };   
        
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions("Update Plant", "Choose a property to update", menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);
            switch (choice) {
                case 1:
                    plant.setPlantName(scanner.nextLine());                 
                    break;
                case 2:
                    plant.setPlantType(scanner.nextLine());
                    break;
                case 3:
                    plant.setDatePlanted(scanner.nextLine());
                    break;
                case 4:
                    plant.setPlantSpacing(scanner.nextLine());
                    break;
                case 5:
                    plant.setAlive(scanner.nextLine());
                    break;
            }
        }


    }

    public void viewPlants(){
        //for loop that iterates and prints
        for (Plant plant : garden) {
            System.out.println(plant);
        }

    }

    public void viewPlantsAlpha(){
        Collections.sort(garden);
        viewPlants();
    }

    public void viewPlantsAlive(){
        Collections.sort(garden);
        for (Plant plant : garden) {
            if (plant.isAlive()) {
                System.out.println(plant);
            }
        }
    }

    public void viewPlantsByDate(){
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

    public void viewPlantsBySpacing(){
        Collections.sort(garden);
        garden.sort(Comparator.comparing(plant -> plant.getPlantSpacing()));
        viewPlants();
    }


    
}
