package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Helpers {
    
    public static void testData(Scanner scanner){
        
        Plant plant1 = new Plant(); // default
        //    public Plant(String plantName, String plantType, String datePlanted, int plantHeight, boolean alive)
        Plant plant2 = new Plant("Basil", "Herb", "2021-04-20", 5, true);
        System.out.println(plant1);
        System.out.println(plant2);

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

    

    
}
