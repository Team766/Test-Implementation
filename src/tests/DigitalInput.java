package tests;

import interfaces.DigitalInputReader;

public class DigitalInput implements DigitalInputReader{
	
	private boolean sensor = false;

	public boolean get() {
		return sensor;
	}
	
	public void set(boolean on){
		sensor = on;
	}

}
