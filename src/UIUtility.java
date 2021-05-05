package src;

import java.util.Scanner;
public class UIUtility {
    /**
     * Displays a menu and the prompt, returning the String entered by the user.
     *
     * @param menuTitle the title of the menu
     * @param prompt the prompt for input
     * @param menuOptions the list of menu options to display
     * @param in a Scanner object
     * @return the user's response
     */
    public static int showMenuOptions(String menuTitle, String prompt, String[] menuOptions, Scanner scanner) {
        showMenuTitle(menuTitle);
        int count = 1;
        for (String menuOption : menuOptions) {
            System.out.println(count++ + ": " + menuOption);
        }
        System.out.println(count + ": Exit");
        System.out.print("\n" + prompt + " ");
        String input = scanner.nextLine().trim();
        int result = validateIntInput(input, menuOptions.length + 1, scanner);
        return result;
    }

    /**
     * Displays a properly formatted menu title.
     *
     * @param menuTitle the text of the title
     */
    public static void showMenuTitle(String menuTitle) {
        System.out.println("\n" + "xxx " + menuTitle + " xxx\n");
    }

    /**
     * A string is converted to an integer. If invalid, a message will display.
     *
     * @param input The string representing an integer
     * @param in a Scanner object
     * @return The string converted to an integer, or 0 if invalid
     */

    public static int validateIntInput(String input, int highBound, Scanner scanner) {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
            if (intInput < 1 || intInput > highBound) {
                intInput = 0;
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input", scanner);
        }
        return intInput;
    }
    
    public static int validateIntInput(String input, Scanner scanner) {
        
        int intInput;

        while (true) {
            try {
                intInput = Integer.parseInt(input);   
                return intInput;    
                
            } catch(Exception e){
                showErrorMessage("Invalid input", scanner);
                System.out.print("Please enter a number: ");
                input = scanner.nextLine();
                validateIntInput(input, scanner);
            }
        }        
    }

    public static int validateIntInput(String input, int lowBound, int highBound, Scanner scanner) {
        
        int intInput;

        while (true) {
            try {
                intInput = Integer.parseInt(input);
                if (intInput < lowBound || intInput > highBound) {                
                    throw new NumberFormatException();
                }    
                return intInput;
    
            } catch (NumberFormatException e) {
                showErrorMessage("Out of Range", scanner);
                System.out.print("Please enter a number: ");
                input = scanner.nextLine();
                validateIntInput(input, lowBound, highBound, scanner);
    
            } catch(Exception e){
                showErrorMessage("Invalid input", scanner);
                System.out.print("Please enter a number: ");
                input = scanner.nextLine();
                validateIntInput(input, lowBound, highBound, scanner);
            }
        }        
    }


    /**
     * Displays the supplied message.  If waitForAcknowledement is true, will
     * also call pressEnterToContinue().
     *
     * @param message The error message
     * @param in a Scanner object
     */

    public static void showErrorMessage(String message, Scanner scanner) {
        System.out.println("ERROR: " + message);
          pressEnterToContinue(scanner);
    }

    /**
     * Displays a wait prompt and waits for the user to hit the enter key.
     * 
     * @param in a Scanner object
     */

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.print("\nPress Enter to continue... ");
        scanner.nextLine();
    }


    /**
     * Displays the supplied title text in a consistently formatted manner.
     *
     * @param title The text to display
     */
    public static void showSectionTitle(String title){
        System.out.println( "\n" + "*** " + title + " ***\n");
    }

    public static int[] coordsFromSelection(int coordInt){
        
        int x = 0;
        int y = 0;

        // kind of wierd but I couldn't come up with a clever way
        if (coordInt == 1){
            x = 0;
            y = 0;
        }
        else if(coordInt == 2){
            x = 0;
            y = 1;
        }
        else if (coordInt == 3) {
            x = 0;
            y = 2;
        }
        if (coordInt == 4){
            x = 1;
            y = 0;
        }
        else if(coordInt == 5){
            x = 1;
            y = 1;
        }
        else if (coordInt == 6) {
            x = 1;
            y = 2;
        }
        if (coordInt == 7){
            x = 2;
            y = 0;
        }
        else if(coordInt == 8){
            x = 2;
            y = 1;
        }
        else if (coordInt == 9) {
            x = 2;
            y = 2;
        }
        if (coordInt == 10){
            x = 3;
            y = 0;
        }
        else if(coordInt == 11){
            x = 3;
            y = 1;
        }
        else if (coordInt == 12) {
            x = 3;
            y = 2;
        }
        
        int[] coords = {x,y};
        return coords;

    }

    public static int chooseCoords(Scanner scanner){
        System.out.print("Choose the position: ");
        int pickANum = UIUtility.validateIntInput(scanner.nextLine(), 0, 13, scanner);        
        return pickANum;
    }

    public static void printNPause(Plant plant, Scanner scanner){
        System.out.println(plant.toString());
        UIUtility.pressEnterToContinue(scanner);
    }

    public static void printFormatLine(){
        System.out.format("                 +-------------------+-------------------+-------------------+%n");
    }
    public static void printFirstFormatLine(){
        System.out.format("-------------    +-------------------+-------------------+-------------------+%n");
    }

    public static int printGardenBed(String[][] gardenBed, Scanner scanner){
        // https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console  

        String[] menuOptions = {
            "1: Add",
            "2: Remove",
            "3: Swap",
            "4: Exit"
        };
        System.out.println("\n" + "xxx " + "Garden Bed" + " xxx\n");

        String row1Format = " %-15s | 1 %-15s | 2 %-15s | 3 %-15s | %n";
        String row2Format = " %-15s | 4 %-15s | 5 %-15s | 6 %-15s | %n";
        String row3Format = " %-15s | 7 %-15s | 8 %-15s | 9 %-15s | %n";
        String row4Format = " %-15s | 10 %-14s | 11 %-14s | 12 %-14s | %n";        
        
        System.out.println("Menu Options:     A virtual representation of a 4x3 foot garden bed.");
        printFirstFormatLine();     

        System.out.format(row1Format, menuOptions[0], gardenBed[0][0], gardenBed[0][1] , gardenBed[0][2]);
        printFormatLine();   
        System.out.format(row2Format, menuOptions[1], gardenBed[1][0], gardenBed[1][1] , gardenBed[1][2]);
        printFormatLine();   
        System.out.format(row3Format, menuOptions[2],  gardenBed[2][0], gardenBed[2][1] , gardenBed[2][2]);
        printFormatLine();   
        System.out.format(row4Format, menuOptions[3],  gardenBed[3][0], gardenBed[3][1] , gardenBed[3][2]);
        
        printFormatLine();

        System.out.print("\n" + "Choose an option to modify the bed:" + " ");
        String input = scanner.nextLine().trim();
        int result = UIUtility.validateIntInput(input, menuOptions.length + 1, scanner);

        return result;       
        
    }


}