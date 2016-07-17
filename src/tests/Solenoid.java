package tests;
import interfaces.SolenoidController;


public class Solenoid implements SolenoidController{

	private boolean pist;
	
	public Solenoid(int port){
		pist = false;
	}
	
	public void set(boolean on) {
		pist = on;
	}

	public boolean get() {
		return pist;
	}

}
