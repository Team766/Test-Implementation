import interfaces.JoystickReader;


public class Joystick implements JoystickReader{
	
	private int port;
	
	public Joystick(int index){
		port = index;
	}
	
	public double getRawAxis(int axis) {
		return ((System.currentTimeMillis()/1000d) * (1 + axis * 0.1)) % 2 - 1;
	}

	public boolean getRawButton(int button) {
		return false;
	}

}
