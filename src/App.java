package src;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String menuTitle = "Main Menu";
        String prompt = "Select an option:";
        String[] menuOptions = {
            "Add a Plant",
            "View Plants in Garden",
            "Update a Plant",
            "Remove a Plant",
            "Plant positions in Garden Bed"
        };
        int choice = 0;

        // Added this as a convenience for testing for myself
        //Garden.seedData();

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
                    //UIUtility.pressEnterToContinue(scanner);
                    break;
                case 3:
                    //Update a Plant
                    if (Garden.getCountInGarden() == 0) {
                        System.out.println("There are no plants in the garden.");
                    }
                    else{
                        Plant plant = selectPlantFromGarden(scanner,Garden.getGarden());
                        if (plant == null) break;
                        plantFieldMenu(plant, scanner);
                        //UIUtility.pressEnterToContinue(scanner);
                    }
                    break;
                case 4:
                    //remove a plant
                    if (Garden.getCountInGarden() == 0) {
                        System.out.println("There is nothing in the garden.");
                    }
                    else{                                                    
                        Plant plant = selectPlantFromGarden(scanner,Garden.getGarden());
                        if (plant == null) break;
                        Garden.removePlant(plant);
                        System.out.println("Removed\n" + plant.toString());                          
                        UIUtility.pressEnterToContinue(scanner);                  
                    }
                    break;
                case 5:
                     // "plant" the items in a garden bed
                    // select plants to put in a garden bed
                    // limit the size by space
                    // add, remove, swap
                    
                    addRemoveUpdateBed(scanner, Garden.getGardenBed());
                    
                    break;
            }
        }
       System.out.println("\nProgram complete. Goodbye.\n");
       scanner.close();
    }

    public static Plant selectPlantFromGarden(Scanner scanner, List<Plant> garden){
        
        String[] menuOptions = new String[garden.size()];
        // List<Plant> garden = Garden.getGarden();
        // Collections.sort(garden);

        for (int i = 0; i < menuOptions.length ; i++) {
            menuOptions[i] = garden.get(i).getPlantName() + " " + garden.get(i).getDatePlanted();
        }

        int choice = 0;
        Plant plant = null;
        while (true) {
            choice = UIUtility.showMenuOptions("Garden" , "Choose a plant: ", menuOptions, scanner);
            if (choice == 0) continue;
            if (choice == menuOptions.length + 1)break;
                
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);
            // grab the plant that the user selected

            if (choice >= 1 && choice <= menuOptions.length) {
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

    public static void addRemoveUpdateBed(Scanner scanner, String[][] coords){
        
        int choice = 0;
        boolean cont = true;
        while (cont) {

            choice = UIUtility.printGardenBed(Garden.getGardenBed(), scanner);

            if (choice == 0)
                continue;
            if (choice == 5)
                break;        
            switch (choice) {
                case 1:
                    //add
                    Plant plant = selectPlantFromGarden(scanner, Garden.getPlantsToPlant());
                    if (plant == null) break;

                    //The plant is too big for the 1x1 foot square
                    if (plant.getPlantSpacing() > 12) {
                        System.out.println("The plant is too big for this garden.");
                        break;
                    }

                    int addCoord = UIUtility.chooseCoords(scanner);

                    int[] AddXY = UIUtility.coordsFromSelection(addCoord);

                    if (!coords[AddXY[0]][AddXY[1]].isEmpty()) {
                        System.out.println("Remove the plant before placing a new one.");
                        break;
                    }

                    String name = plant.getPlantName();
                    int nameLength = 11;

                    // do some formating so the name fits in box
                    if (name.length() >= nameLength) name = name.substring(0,   nameLength) +"...";                    
                    else if (name.equals(null)) name = "";
                    
                    // set the array to the name
                    coords[AddXY[0]][AddXY[1]] = name;
                    
                    // set the plant object's garden coords field
                    plant.setGardenCoords(AddXY);

                    
                    break;
                case 2:
                    // remove
                    int removeCoord = UIUtility.chooseCoords(scanner);
                    int[] removeXY = UIUtility.coordsFromSelection(removeCoord);
                    Garden.setGardenBedByCoord(removeXY, "");

                    // remove the plant's coordinates field
                    int index = Garden.getPlantIndexByCoord(removeXY);
                    int[] nonCoords ={-1,-1};

                    Garden.getGarden().get(index).setGardenCoords(nonCoords);
                    
                    break;
                case 3:
                    // swap
                    System.out.print("First plant- ");
                    int swap1Coord = UIUtility.chooseCoords(scanner);

                    System.out.print("Second plant- ");
                    int swap2Coord = UIUtility.chooseCoords(scanner);

                    // swap in garden bed

                    int[] swap1XY = UIUtility.coordsFromSelection(swap1Coord);
                    int[] swap2XY = UIUtility.coordsFromSelection(swap2Coord);

                    String temp1 = Garden.getGardenBedByCoord(swap1XY);

                    Garden.setGardenBedByCoord(swap1XY, Garden.
                        getGardenBedByCoord(swap2XY));
                    
                    Garden.setGardenBedByCoord(swap2XY, temp1);

                    // set coords
                    int swap1 = Garden.getPlantIndexByCoord(swap1XY);
                    int swap2 = Garden.getPlantIndexByCoord(swap2XY);

                    Garden.getGarden().get(swap1).setGardenCoords(swap2XY);
                    Garden.getGarden().get(swap2).setGardenCoords(swap1XY);
                    
                    break;
                case 4:
                    // exit
                    cont = false;
                    break;
            }            
        }        
    }


    public static void printNPause(Plant plant, Scanner scanner){
        System.out.println(plant.toString());
        UIUtility.pressEnterToContinue(scanner);
    }



}