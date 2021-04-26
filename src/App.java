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
            "View by Alhpa",
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
                    addPlant(scanner);

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

                    break;
                case 4:
                    //remove a plant
                    break;
                case 5:
                    //seed data
                    seedData();
                    break;
                case 6:
                    Garden.viewPlantsAlpha();
                    break;
                case 7:
                    Garden.viewPlantsAlive();
                    break;
                case 8:
                     Garden.viewPlantsByDate();
                    break;
                case 9:
                    Garden.viewPlantsBySpacing();
                    break;

            }
        }
       System.out.println("\nProgram complete. Goodbye.\n");
       scanner.close();
    }

    private static void seedData() {
        Plant plant1 = new Plant(); // default
        Plant plant4 = new Tomato("Big Beef", "Fruit", "2021-05-20", 12, true, 12, "Red");
        Plant plant2 = new Plant("Basil", "Herb", "2021-04-20", 5, true);
        Plant plant3 = new Tomato();
        Plant plant5 = new Plant("Apple", "Fruit", "2019-09-20", 24, true);
        Plant plant6 = new Plant("Zucchini", "Squash", "2021-04-19", 10, true);

        Garden.addPlant(plant1);
        Garden.addPlant(plant2);
        Garden.addPlant(plant3);
        Garden.addPlant(plant4);
        Garden.addPlant(plant5);
        Garden.addPlant(plant6);
    }
    
    public static void addPlant(Scanner scanner){

        String plantName = Helpers.input(scanner, "Write the plant name");
        String plantType = Helpers.input(scanner, "Write the plant type");
        String datePlanted = Helpers.input(scanner, "Enter the date planted [YYYY-MM-DD]");
        int plantSpacing = UIUtility.validateIntInput(Helpers.input(scanner, "Enter the spacing"), 24, scanner);
        String aliveString = Helpers.input(scanner, "Is the plant alive [1-yes, 2-No]");
        // int aliveInt = UIUtility.validateIntInput(aliveString, 2, scanner);
        boolean alive = aliveString.equals("1") || aliveString.trim().toLowerCase().charAt(0) == 'y' ? true : false;

        Plant plant = new Plant();

        plant.setPlantName(plantName);
        plant.setPlantType(plantType);
        plant.setDatePlanted(datePlanted);
        plant.setPlantSpacing(plantSpacing);
        plant.setAlive(alive);

        Garden.addPlant(plant);

        System.out.println("Book added.");
        UIUtility.pressEnterToContinue(scanner);


    }
    
}