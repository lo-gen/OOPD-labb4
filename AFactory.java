import java.util.Random;

public class AFactory<carTYpe extends ICar> {

    private static final Random random = new Random();

    public static Car addCar() {
        int carType = random.nextInt(3);

        switch (carType) {
            case 0:
                return new Volvo240();
            case 1:
                return new Saab95();
            case 2:
                return new Scania();
            default:
                return new Volvo240();
        }
    }



}
