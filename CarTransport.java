import java.awt.*;
import java.util.ArrayList;

public class CarTransport<carType extends IPassagerCar> extends Car implements ITruck{
    private StorageUnit<carType> storage;
    private boolean rampUp;

    public CarTransport(int totalSpace){
        super(2, 500, Color.RED, "CarTransport");
        storage = new StorageUnit<>(totalSpace);
        rampUp = false;
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.001;
    }

    protected void rampUp(){
        rampUp = true;
    }

    protected void rampDown(){
        if (0 < getCurrentSpeed()) {
            throw new IllegalStateException("Can't lower ramp when moving");
        } else {
            rampUp = false;
        }
    }

    public boolean getRampUpStatus(){
        return rampUp;
    }

    protected int getSpaceUsed(){
        return storage.getSpaceUsed();
    }

    protected int getSpaceLeft(){
        return storage.getSpaceLeft();
    }

    private double distanceBetween(carType car){
        return Math.sqrt(Math.pow(car.getXPos() - getXPos(), 2) + Math.pow(car.getYPos() - getYPos(), 2));
    }

    protected void addCar(carType car){
        if (6.9 < distanceBetween(car)) {
            throw new IllegalStateException("Car is too far away");
        } else if (rampUp) {
            throw new IllegalStateException("Can't load when ramp is up");
        } else if (getSpaceLeft() == 0) {
            throw new IllegalStateException("Storage is full");
        } else {
            storage.addItem(car);
            car.setXYPos(getXPos(), getYPos());
            car.setIsStoredTrue();
        }
    }

    protected carType removeCar(){
        if (rampUp){
            throw new IllegalStateException("Can't unload when ramp is up");
        } else if (getSpaceUsed() == 0) {
            throw new IllegalStateException("There is no car to unload");
        } else {
            carType car = storage.removeLastItem();
            car.setIsStoredFalse();
            car.setXYPos(getXPos() + 2, getYPos());
            return car;
        }
    }

    protected ArrayList<carType> getCars(){
        return storage.getItems();
    }

    @Override
    public void gas(double amount){
        if (!rampUp) {
            throw new IllegalStateException("Can't drive when ramp is down");
        } else {
            super.gas(amount);
        }
    }

    @Override
    public void move(){
        super.move();
        for (carType car : storage.getItems()){
            car.setXYPos(getXPos(), getYPos());
        }
    }
}

