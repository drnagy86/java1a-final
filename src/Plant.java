package src;
import java.time.LocalDate;

public class Plant implements Comparable<Plant>{
    //create instance variables
    private String plantName;
    private String plantType;
    private LocalDate datePlanted;
    private int plantHeight;
    private boolean alive;

    //default constructor
    public Plant(){
        this.plantName = "No plant name";
        this.plantType = "No plant type";
        this.datePlanted = LocalDate.now();
        this.plantHeight = 0;
        this.alive = false;
    }

    //constructor taking in the input
    public Plant(String plantName, String plantType, String datePlanted, int plantHeight, boolean alive){
        this.plantName = plantName;
        this.plantType = plantType;
        this.datePlanted = Helpers.convertStrToDate(datePlanted);
        this.plantHeight = plantHeight;
        this.alive = alive;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public LocalDate getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(String datePlanted) {
        this.datePlanted = Helpers.convertStrToDate(datePlanted);
    }

    public int getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(int plantHeight) {
        this.plantHeight = plantHeight;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
    public String toString(){
        String result = "";

        result += "Name: " + plantName;
        result += ", Plant Type: " + plantType;
        result += ", Date Planted: " + datePlanted;

        return result;
    }

    // this is called an annotation
    @Override
    public int compareTo(Plant o){
        int result = this.plantName.compareToIgnoreCase(o.plantName);

        if (result == 0) {
            result = this.datePlanted.compareTo(o.datePlanted);
        }
        return result;
    }


}
