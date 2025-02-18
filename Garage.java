public class Garage<carType extends ICar>{
    private final StorageUnit<carType> myGarage;
    private final double xPos;
    private final double yPos;

    public Garage(int totalSpace, double xPos, double yPos){
        myGarage = new StorageUnit<>(totalSpace);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public double getXPos(){
        return xPos;
    }

    public double getYPos(){
        return yPos;
    }

    protected int getSpaceUsed(){
        return myGarage.getSpaceUsed();
    }

    protected int getSpaceLeft(){
        return myGarage.getSpaceLeft();
    }

    protected void addCar(carType car){
        myGarage.addItem(car);
    }

    protected void removeItem(carType car){
        myGarage.removeSpecificItem(car);
    }
}
