import java.util.ArrayList;

public class Garage<carType extends IPassagerCar> {
    private final StorageUnit<carType> myGarage;
    private ArrayList<carType> storedCars;
    private final double xPos;
    private final double yPos;

    public Garage(int totalSpace, double xPos, double yPos) {
        myGarage = new StorageUnit<>(totalSpace);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    protected int getSpaceUsed() {
        return myGarage.getSpaceUsed();
    }

    protected int getSpaceLeft() {
        return myGarage.getSpaceLeft();
    }

    private double distanceBetween(carType car) {
        return Math.sqrt(Math.pow(car.getXPos() - getXPos(), 2) + Math.pow(car.getYPos() - getYPos(), 2));
    }

    protected void addCar(carType car) {
        if (2 < distanceBetween(car)) {
            throw new IllegalStateException("Car is too far away");
        } else {
            myGarage.addItem(car);
        }
    }

    /*
    protected void addCar(carType car){
        myGarage.addItem(car);
    }
    **/


    protected void removeItem(carType car) {
        myGarage.removeSpecificItem(car);
    }



}