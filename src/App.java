package src;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String menuTitle = "Main Menu";
        String prompt = "Select an option:";
        String[] menuOptions = {
            "Add a Plant",
            "View Garden",
            "Update a Plant",
            "Remove a Plant",
            "Seed objects"
        };
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);
            switch (choice) {
                case 1:
                    // Add a plant
                    Garden.addPlant(scanner);
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 2:
                    //View Menu
                    viewsMenu(scanner);
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 3:
                    //Update a Plant
                    if (Garden.getCountInGarden() == 0) {
                        System.out.println("There are no plants in the garden.");
                    }
                    else{
                        Plant plant = selectPlantFromGarden(scanner);
                        plantFieldMenu(plant, scanner);
                        UIUtility.pressEnterToContinue(scanner);
                    }
                    break;
                case 4:
                    //remove a plant
                    if (Garden.getCountInGarden() == 0) {
                        System.out.println("There is nothing in the garden.");
                    }
                    else{                                                    
                        Plant plant = selectPlantFromGarden(scanner);
                        System.out.println("Removed\n" + plant.toString());                          
                        UIUtility.pressEnterToContinue(scanner);                  
                    }
                    break;
                case 5:
                    //seed data
                    Garden.seedData();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
            }
        }
       System.out.println("\nProgram complete. Goodbye.\n");
       scanner.close();
    }

    public static Plant selectPlantFromGarden(Scanner scanner){

        
        String[] menuOptions = new String[Garden.getCountInGarden()];
        List<Plant> garden = Garden.getGarden();
        Collections.sort(garden);

        for (int i = 0; i < menuOptions.length ; i++) {
            menuOptions[i] = garden.get(i).getPlantName() + " " + garden.get(i).getDatePlanted();
        }

        int choice = 0;
        Plant plant = null;
        while (true) {
            choice = UIUtility.showMenuOptions("Garden" , "Choose a plant: ", menuOptions, scanner);
            // if (choice == 0)
            //     continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);
            // grab the plant that the user selected
            if (choice >= 0 && choice <= menuOptions.length) {
                plant = garden.get(choice - 1);
                break;
            }
        }
        return plant;
    }

    public static void plantFieldMenu(Plant plant, Scanner scanner){
        String[] menuOptions = {
            "Plant Name",
            "Plant Type",
            "Date Planted",
            "Plant Spacing",
            "Is alive?"
        };   
        
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions("Update " + plant.getPlantName(), "Choose a property to update: ", menuOptions, scanner);
            // if (choice == 0)
            //     continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);            
            switch (choice) {
                case 1:
                    plant.setPlantName(scanner.nextLine());
                    printNPause(plant, scanner);               
                    break;
                case 2:
                    plant.setPlantType(scanner.nextLine());
                    printNPause(plant, scanner);
                    break;
                case 3:
                    plant.setDatePlanted(scanner.nextLine());
                    printNPause(plant, scanner);
                    break;
                case 4:

                    int plantSpacing = UIUtility.validateIntInput(Helpers.input(scanner, "Enter the spacing"), 24, scanner);
                    plant.setPlantSpacing(plantSpacing);
                    printNPause(plant, scanner);
                    break;
                case 5:
                    String aliveString = Helpers.input(scanner, "Is the plant alive [1-yes, 2-No]");
                    // int aliveInt = UIUtility.validateIntInput(aliveString, 2, scanner);
                    boolean alive = aliveString.equals("1") || aliveString.trim().toLowerCase().charAt(0) == 'y' ? true : false;

                    plant.setAlive(alive);
                    printNPause(plant, scanner);
                    break;
            }

            
        }

        
    }

    public static void viewsMenu(Scanner scanner){
        String[] menuOptions = {
            "View Alphabetically",
            "View Alive Plants",
            "View Plants by Date",
            "View Plant by Spacing"
        };   
        
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions("View Garden", "Choose a view:", menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);            
            switch (choice) {
                case 1:

                    Garden.viewPlantsAlpha();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 2:
                    Garden.viewPlantsAlive();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 3:
                    Garden.viewPlantsByDate();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 4:
                    Garden.viewPlantsBySpacing();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
            }            
        }        
    }

    public static void printNPause(Plant plant, Scanner scanner){
        System.out.println(plant.toString());
        UIUtility.pressEnterToContinue(scanner);
    }



}