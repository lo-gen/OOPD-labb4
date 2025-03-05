import javax.swing.*;

public class CarApplication {




    public static void main(String[] args) {
        CarController cc = new CarController();

        IObserver observer = new CarView("CarSim 1.0", cc);

        cc.addObserver(observer);

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
        cc.frame = (CarView)observer;

        // Start the timer
        cc.timer.start();
    }
}
