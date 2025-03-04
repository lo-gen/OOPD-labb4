import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    private HashMap<Car, Point> carPositions = new HashMap<>();
    private HashMap<Garage<Volvo240>, Point>  garagePositions = new HashMap<>();

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    BufferedImage getcarImage(Car car) {
        if (car instanceof Volvo240) {
            return volvoImage;
        } else if (car instanceof Saab95) {
            return saabImage;
        } else if (car instanceof Scania) {
            return scaniaImage;
        }
        return null;
    }
    /*
    BufferedImage getCarImage(Car car){
        switch(car instanceof ) {
            case x:
                // code block
                break;
            case y:
                // code block
                break;
            default:
                // code block
        }
    }
    */


    // To keep track of a single car's position


    BufferedImage volvoWorkshopImage;


    void addGarage(Garage<Volvo240> garage, int x, int y) {
        if (garagePositions.containsKey(garage)) {
            garagePositions.get(garage);
        } else {
            garagePositions.put(garage, new Point(x, y));
        }
    }





    // TODO: Make this general for all cars
    void moveit(int x, int y, Car car) {
        if (carPositions.containsKey(car)) {
            carPositions.get(car).setLocation(x, y);
        } else {
            carPositions.put(car, new Point(x, y));
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

           // allImages = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/*.jpg"));


        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Car> carsToRemove = new ArrayList<>();

        for (Car car : carPositions.keySet()) {
            Point carPos = carPositions.get(car);
            BufferedImage carImage = getcarImage(car);
            if (car instanceof  Volvo240) {
                for (Garage<Volvo240> garage : garagePositions.keySet()) {
                    if (Math.abs(garage.getXPos() - car.getXPos()) < 10 && Math.abs(garage.getYPos() - car.getYPos()) < 10) {
                        garage.addCar((Volvo240) car);
                        carsToRemove.add(car);
                        car.stopEngine();
                    }
                    g.drawImage(volvoWorkshopImage, (int) garage.getXPos(), (int) garage.getYPos(), null);
                    // Inte klar ännu

                }
            }
            if (!carsToRemove.contains(car) && carImage != null) {
                g.drawImage(carImage, carPos.x, carPos.y, null);
            }
        }
        for (Car car : carsToRemove) {
            carPositions.remove(car);
        }

    }
}
