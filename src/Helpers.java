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

        Plant plant3 = new Tomato();
        Plant plant4 = new Tomato("Big Beef", "Fruit", "2021-04-21", 12, true, 12, "Red");


        System.out.println(plant1);
        System.out.println(plant2);
        System.out.println(plant3);
        System.out.println(plant4);

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
