import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    Car volvo1 = new Volvo240();

    Car Saab1 = new Saab95();

    Car Scania1 = new Scania();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Garage<Volvo240>> garages = new ArrayList<>();

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();



    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        double startY = 0;

        Volvo240 volvo = new Volvo240();
        volvo.setXYPos(0, startY);
        cc.cars.add(volvo);

        Saab95 saab = new Saab95();
        saab.setXYPos(0, startY + 100);
        cc.cars.add(saab);

        Scania scania = new Scania();
        scania.setXYPos(0, startY + 200);
        cc.cars.add(scania);

        Garage<Volvo240> volvoWorkshop = new Garage<>(10, 300, 0);
        cc.garages.add(volvoWorkshop);





        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

    }



    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) car.getXPos();
                int y = (int) car.getYPos();

                if(0 > x || x >= dim.width/2 -80) {
                    car.setAngle(car.getAngle() + Math.PI);
                }

                /*if (Math.abs(garages.getFirst().getXPos() - car.getXPos()) < 10) {
                    car.stopEngine();
                }*/
                for (Garage<Volvo240> garage : garages) {
                    frame.drawPanel.addGarage(garage);
                }

                frame.drawPanel.moveit(x, y, car);


                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
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

}
