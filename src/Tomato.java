package src;

public class Tomato extends Plant {
    private int fruitSize;
    private String color;
    // could add fruit size and color

    public Tomato() {
        //call to the parent constructor
        super();
        fruitSize = 0;
        color = "No color added";
    }

    public Tomato(String plantName, String plantType, String datePlanted, int plantHeight, boolean alive, int fruitSize, String color){
        super(plantName, plantType, datePlanted, plantHeight, alive);
        this.fruitSize = fruitSize;
        this.color = color;
    }

    public int getFruitSize() {
        return fruitSize;
    }

    public void setFruitSize(int fruitSize) {
        this.fruitSize = fruitSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        String result = super.toString();

        result += ", Fruit Size: " + fruitSize;
        result += ", Color: " + color;



        return result;
        
    }



}
