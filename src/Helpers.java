package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Helpers {

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
