import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    
}
