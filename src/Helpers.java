package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Helpers {

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
            choice = UIUtility.showMenuOptions("Garden" , "Choose a plant", menuOptions, scanner);
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
