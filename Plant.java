package src;

import java.time.LocalDate;


public class Plant implements Comparable<Plant>{
    //create instance variables
    private String plantName;
    private String plantType;
    private LocalDate datePlanted;
    private int plantHeight;
    private boolean alive;


    public Plant(){
        this.plantName = "";
        this.plantType = "";
        this.datePlanted = LocalDate.now();
        this.plantHeight = 0;
        this.alive = true;
    }

    public Plant(String plantName, String plantType, String datePlanted, int plantHeight, boolean alive){
        this.plantName = plantName;
        this.plantType = plantType;
        this.datePlanted = convertStrToDate(datePlanted);
        this.plantHeight = plantHeight;
        this.alive = alive;
    }



    public int compareTo(Plant o){
        int result = this.plantName.compareToIgnoreCase(o.plantName);

        if (result == 0) {
            result = this.localDate.compareTo(o.localDate);
        }
        return result;
    }


}
