import java.awt.*;

public class Saab95 extends Car implements IPassagerCar{

    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
        stopEngine();
    }

    public boolean getTurboOn(){
        return turboOn;
    }

    protected void setTurboOn(){
	    turboOn = true;
        throw new IllegalStateException("Turbo is on");

    }

    protected void setTurboOff(){
	    turboOn = false;
        throw new IllegalStateException("Turbo is off");

    }
    
    @Override public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}