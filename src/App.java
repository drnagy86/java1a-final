package src;
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
            "Seed objects",
            "View Alphabetically",
            "View Alive Plants",
            "View Plants by Date",
            "View Plant by Spacing"
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
                    //View Garden
                    //View Menu
                    Garden.viewPlants();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 3:
                    //Update a Plant
                    Garden.updatePlant(scanner);
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 4:
                    //remove a plant
                    if (Garden.getCountInGarden() == 0) {
                        System.out.println("There is nothing in the garden.");
                    }
                    else{                                                    
                        Garden.removePlant(scanner);  
                        UIUtility.pressEnterToContinue(scanner);                  
                    }
                    break;
                case 5:
                    //seed data
                    Garden.seedData();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 6:
                    Garden.viewPlantsAlpha();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 7:
                    Garden.viewPlantsAlive();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
                case 8:
                     Garden.viewPlantsByDate();
                     UIUtility.pressEnterToContinue(scanner);
                    break;
                case 9:
                    Garden.viewPlantsBySpacing();
                    UIUtility.pressEnterToContinue(scanner);
                    break;
            }
        }
       System.out.println("\nProgram complete. Goodbye.\n");
       scanner.close();
    }
}