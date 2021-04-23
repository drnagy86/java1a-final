package src;
import java.time.LocalDate;

public class Plant implements Comparable<Plant>{
    //create instance variables
    private String plantName;
    private String plantType;
    private LocalDate datePlanted;
    private int plantSpacing;
    private boolean alive;

    //default constructor
    public Plant(){
        this.plantName = "No plant name";
        this.plantType = "No plant type";
        this.datePlanted = LocalDate.now();
        this.plantSpacing = 0;
        this.alive = false;
    }

    //constructor taking in the input
    public Plant(String plantName, String plantType, String datePlanted, int plantSpacing, boolean alive){
        this.plantName = plantName;
        this.plantType = plantType;
        this.datePlanted = Helpers.convertStrToDate(datePlanted);
        this.plantSpacing = plantSpacing;
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

    public int getPlantSpacing() {
        return plantSpacing;
    }

    public void setPlantSpacing(String plantSpacing) {
        this.plantSpacing = Helpers.validateIntInput(plantSpacing, 0 , 24);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(String alive) {        
        alive = alive.trim().substring(0, 1).toLowerCase();
        if (alive.equals("y") || alive.equals("t")) {
            this.alive = true;            
        } else if(alive.equals("n") || alive.equals("f")){
            this.alive = false;
        } else {
            System.out.println("Must choose Yes/No or True/False.");
        }        
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

    public int compareToDate(Plant o){
        int result = this.datePlanted.compareTo(o.datePlanted);
        
        if (result == 0) {
            result = this.plantName.compareToIgnoreCase(o.plantName);
        }
        return result;
    }



}
