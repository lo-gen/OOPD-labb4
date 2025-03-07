import javax.swing.*;

public class CarApplication {




    public static void main(String[] args) {
        CarController cc = new CarController();

        CarModel cm = new CarModel();

        DrawPanel drawPanel = new DrawPanel(800, 560, cm);

        CarView cv = new CarView("CarSim 1.0", cm, drawPanel);

        cm.addObserver(cv);

        double startY = 0;

        Volvo240 volvo = new Volvo240();
        volvo.setXYPos(0, startY);
        cm.cars.add(volvo);

        Saab95 saab = new Saab95();
        saab.setXYPos(0, startY + 100);
        cm.cars.add(saab);

        Scania scania = new Scania();
        scania.setXYPos(0, startY + 200);
        cm.cars.add(scania);

        Garage<Volvo240> volvoWorkshop = new Garage<>(10, 300, 0);
        cm.addGarage(volvoWorkshop, 300, 0);
        cm.garages.add(volvoWorkshop);


        





        // Start a new view and send a reference of self
        //cv.frame;

        // Start the timer
        cm.timer.start();
    }
}
