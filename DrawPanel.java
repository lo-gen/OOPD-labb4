import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize

    CarModel carM;


    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;

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

    // To keep track of a single car's position

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.carM = cm;
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


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (Garage<Volvo240> garage : carM.garagePositions.keySet()) {
            g.drawImage(volvoWorkshopImage, (int) garage.getXPos(), (int) garage.getYPos(), null);


            for (Car car : carM.carPositions.keySet()) {
                Point carPos = carM.carPositions.get(car);
                BufferedImage carImage = getcarImage(car);


                if (carImage != null) {
                    g.drawImage(carImage, carPos.x, carPos.y, null);
                }

            }

        }
    }
}
