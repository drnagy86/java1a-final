package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Helpers {
    
    public static void testData(Scanner scanner){

        Plant plant1 = new Plant(); // default
        
        //    public Plant(String plantName, String plantType, String datePlanted, int plantHeight, boolean alive)
        Plant plant4 = new Tomato("Big Beef", "Fruit", "2021-05-20", 12, true, 12, "Red");
        Plant plant2 = new Plant("Basil", "Herb", "2021-04-20", 5, true);
        Plant plant3 = new Tomato();
        Plant plant5 = new Plant("Apple", "Fruit", "2019-09-20", 24, true);
        Plant plant6 = new Plant("Zucchini", "Squash", "2021-04-19", 10, true);


        Garden garden1 = new Garden();
        garden1.addPlant(plant1);
        garden1.addPlant(plant2);
        garden1.addPlant(plant3);
        garden1.addPlant(plant4);
        garden1.addPlant(plant5);
        garden1.addPlant(plant6);

        // garden1.removePlant(plant1);
        // garden1.removePlant(plant3);        

        //garden1.updatePlant(plant4, scanner);

        //garden1.viewPlants();
        //garden1.viewPlantsAlpha();
        //garden1.viewPlantsAlive();
        //garden1.viewPlantsByDate();
        //garden1.viewPlantsBySpacing();
        UIUtility.pressEnterToContinue(scanner);
    }

    public static void plantUpdateMenu(Plant plant, Scanner scanner){
        String[] menuOptions = {
            "Plant Name",
            "Plant Type",
            "Date Planted",
            "Plant Spacing",
            "Is alive?"
        };   
        
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions("Update " + plant.getPlantName(), "Choose a property to update", menuOptions, scanner);
            if (choice == 0)
                continue;
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

    public static void printNPause(Plant plant, Scanner scanner){
        System.out.println(plant.toString());
        UIUtility.pressEnterToContinue(scanner);
    }

    public static LocalDate convertStrToDate(String dateAdded){        
        LocalDate userDate;
        DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {            
            userDate = LocalDate.parse(dateAdded, formatterInput);
                        
        } catch (DateTimeParseException e) {
            userDate = LocalDate.now();
        }
        return userDate;
    }

    public static String input(Scanner scanner, String prompt){
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static int validateIntInput(String input) {
        
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);   
             
            
        } catch(Exception e){            
            System.out.print("Invalid input\nPlease enter a number: ");
        }
        return intInput;   
                
    }

    public static int validateIntInput(String input, int lowBound, int highBound) {
        
        int intInput = 0;        
        try {
            intInput = Integer.parseInt(input);
            if (intInput < lowBound || intInput > highBound) {                
                throw new NumberFormatException();
            }    
            return intInput;

        } catch (NumberFormatException e) {
            System.out.print("Out of Range.\n" + e.getMessage() + "\nPlease enter a number. ");

        } catch(Exception e){
            System.out.print("Invalid input.\n" + e.getMessage() + "\nPlease enter a number. ");
        }
        return intInput;          

    }

    
}
