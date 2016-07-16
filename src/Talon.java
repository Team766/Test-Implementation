import interfaces.SpeedController;


public class Talon implements SpeedController{

	private int port;
	
	public Talon(int index){
		port = index;
		System.out.println("Talon port: " + index);
	}
	
	public double get() {
		return 0;
	}

	public void set(double speed, byte syncGroup) {
	}

	public void set(double speed) {
//		System.out.println("Talon " + port + ":\t" + speed);
	}

	public void setInverted(boolean isInverted) {
	}

	public boolean getInverted() {
		return false;
	}

	public void stopMotor() {
	}

}
