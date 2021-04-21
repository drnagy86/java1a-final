package src;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private List<Plant> garden;

    public Garden(){
        // number limits the number in the list
        garden = new ArrayList<Plant>(12);

    }

    public void addPlant(Plant plant){
        garden.add(plant);
    }

    public void removePlant(Plant plant){
        garden.remove(plant);
    }

    public void updatePlant(Plant plant){

    }

    public void viewPlants(){
        //for loop that iterates and prints
        for (int i = 0; i < garden.size(); i++) {
            
        }

    }

    public void viewPlantsAlpha(){

    }

    public void viewPlantsAlive(){

    }

    public void viewPlantsByDate(){

    }

    public void viewPlantsByHeight(){
        
    }
    
}
