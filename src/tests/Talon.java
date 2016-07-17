package tests;
import interfaces.SpeedController;


public class Talon implements SpeedController{

	private int port;
	private double output;
	
	public Talon(int index){
		port = index;
		output = 0;
		System.out.println("Talon port: " + index);
	}
	
	public double get() {
		return output;
	}

	public void set(double speed, byte syncGroup) {
		set(speed);
	}

	public void set(double speed) {
		//System.out.println("Talon " + port + ":\t" + speed);
		output = speed;
	}

	public void setInverted(boolean isInverted) {
	}

	public boolean getInverted() {
		return false;
	}

	public void stopMotor() {
		output = 0;
		System.out.println("Stopping motor!");
	}
	
}
