import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    /*Car volvo1 = new Volvo240();

    Car Saab1 = new Saab95();

    Car Scania1 = new Scania();
    */
    // The delay (ms) corresponds to 20 updates a sec (hz)


    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed




    //methods:
/*
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        double startY = 0;

        IObserver observer = new CarView("CarSim 1.0", cc);

        cc.addObserver(observer);


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
        cc.frame = (CarView)observer;

        // Start the timer
        cc.timer.start();

    }
*/



    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


                /*
                if(0 > x || x >= dim.width/2 -80) {
                    car.setAngle(car.getAngle() + Math.PI);
                }

                if (0 > y || y >= dim.height / 2 - 50) {
                    car.setAngle(Math.tan2(-Math.sin(car.getAngle()), Math.cos(car.getAngle())));
                }


                for (Garage<Volvo240> garage : garages) {
                    frame.drawPanel.addGarage(garage, (int) garage.getXPos(), (int) (garage.getYPos()));
                }

                frame.drawPanel.moveit(x, y, car);


                // repaint() calls the paintComponent method of the panel
                notifyObserver();

            }*/
        }





