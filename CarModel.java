import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CarModel implements ISubject{

    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Garage<Volvo240>> garages = new ArrayList<>();
    private ArrayList<IObserver> observers = new ArrayList<>();
    private static final Random random = new Random();

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public void addObserver(IObserver observer){
        if(!observers.contains(observer)) {
            observers.add(observer);
        } else {
            throw new IllegalStateException("Observer already exists");
        }
    }

    public void removeObserver(IObserver observer){
        if (observers.contains(observer)) {
            int observerindex = observers.indexOf(observer);
            observers.remove(observerindex);
        } else {
            throw new IllegalStateException("Observer does not exist");
        }
    }

    public void notifyObserver(){
        for (IObserver observer : observers) {
            observer.Update();
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move();
            int x = (int) car.getXPos();
            int y = (int) car.getYPos();

            if (0 > x || x >= dim.width / 2 - 80) {
                car.setAngle(car.getAngle() + Math.PI);
            }

            if (0 > y || y >= dim.height / 2 - 50) {
                car.setAngle(Math.atan2(-Math.sin(car.getAngle()), Math.cos(car.getAngle())));
            }

        }
        notifyObserver();
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }}
    }

    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void rampUp() {
        for (Car car : cars) {
            if (car instanceof Truck){
                ((Truck) car).rampUp();
            }
        }
    }

    void rampDown() {
        for (Car car : cars) {
            if (car instanceof Truck) {
                ((Truck) car).rampDown();
            }
        }
    }

    void addCar() {
        if (cars.size() < 10) {
            Car car = AFactory.addCar();
            car.setXYPos(random.nextInt(0, dim.width/2 - 80), random.nextInt(0, dim.height/2 -50)); //ändra x och ypos till ett random värde inom dimensionerna av skärmen (dim).
            cars.add(car);
        } else {
            throw new IllegalStateException("Kan inte skapa mer än 10 bilar");
        }

    }

    void removeCar() {
        if(!cars.isEmpty()){
            cars.removeLast();
        } else {
            throw new IllegalStateException("Finns inga bilar att ta bort");
        }
    }
}
