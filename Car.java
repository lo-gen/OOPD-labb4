import java.awt.*;

public abstract class Car implements IMovable, ICar{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPos;
    private double yPos;
    private double positionAngle;
    private boolean isStored = false;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    protected void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    public void setIsStoredTrue() {
        isStored = true;
    }

    public void setIsStoredFalse() {
        isStored = false;
    }

    public boolean getIsStored() {
        return isStored;
    }

    public double getEnginePower(){
        return enginePower;
    }

    protected void setEnginePower(double enginePower){
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = Math.min(enginePower, currentSpeed);
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color color){
        this.color = color;
    }

    public String getModelName(){
        return modelName;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (isStored) {
            throw new IllegalStateException("Can't drive while stored");
        } else {
            amount = Math.min(1, Math.max(0, amount));  //Math.clamp(0, 1, amount)
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (isStored) {
            throw new IllegalStateException("Can't brake while stored");
        } else {
            amount = Math.min(1, Math.max(0, amount));
            decrementSpeed(amount);
        }
    }

    public void setXPos(double xPos){
        this.xPos = xPos;
    }

    public void setYPos(double yPos){
        this.yPos = yPos;
    }

    public void setXYPos(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    protected void setAngle(double positionAngle){
        this.positionAngle = positionAngle;
    }

    public double getXPos(){
        return xPos;
    }

    public double getYPos(){
        return yPos;
    }

    public double getAngle(){
        return positionAngle;
    }

    @Override
    public void move() {
        if (!isStored) {
            throw new IllegalStateException("Can't move while stored");
        } else {
            xPos += currentSpeed * Math.cos(positionAngle);
            yPos += currentSpeed * Math.sin(positionAngle);
        }
    }

    @Override
    public void turnRight() {
        positionAngle -= 5 * Math.PI / 180;     //amount degrees
    }

    @Override
    public void turnLeft(){
        positionAngle += 5 * Math.PI / 180;     //amount degrees
    }
}
