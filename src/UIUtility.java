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

    public static int validateIntInput(String input, int lowBound, int highBound, Scanner in) {
        
        int intInput;

        while (true) {
            try {
                intInput = Integer.parseInt(input);
                if (intInput < lowBound || intInput > highBound) {                
                    throw new NumberFormatException();
                }    
                return intInput;
    
            } catch (NumberFormatException e) {
                showErrorMessage("Out of Range", in);
                System.out.print("Please enter a number: ");
                input = in.nextLine();
                validateIntInput(input, lowBound, highBound, in);
    
            } catch(Exception e){
                showErrorMessage("Invalid input", in);
                System.out.print("Please enter a number: ");
                input = in.nextLine();
                validateIntInput(input, lowBound, highBound, in);
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
}