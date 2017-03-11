package tests;

import interfaces.AnalogInputReader;

public class AnalogInput implements AnalogInputReader{
	
	private double sensor = 0.0;
	
	public void set(double value){
		sensor = value;
	}

	@Override
	public double getVoltage() {
		return sensor;
	}

}
