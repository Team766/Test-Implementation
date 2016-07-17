package tests;
import java.util.Arrays;

import interfaces.JoystickReader;


public class Joystick implements JoystickReader{
	
	private int port;
	private double[] axisValues;
	private boolean[] buttonValues;
	
	public Joystick(int index){
		port = index;
		axisValues = new double[4];	//Fix size to reflect actual joysticks
		Arrays.fill(axisValues, 5);
		buttonValues = new boolean[20];	//Fix size to reflect actual joysticks
	}
	
	public double getRawAxis(int axis) {
		return (axisValues[axis] == 5) ? ((System.currentTimeMillis()/1000d) * (1 + axis * 0.1)) % 2 - 1 : axisValues[axis];
	}

	public boolean getRawButton(int button) {
		return buttonValues[button];
	}
	
	public void setAxisValue(int axis, double value){
		axisValues[axis] = value;
	}
	
	public void setButton(int button, boolean val){
		buttonValues[button] = val;
	}

}
