import interfaces.EncoderReader;


public class Encoder implements EncoderReader{

	public Encoder(int a, int b){
		System.out.println("Encoder ports: " + a + "\t" + b);
	}
	
	public int getRaw() {
		return 0;
	}

	public int get() {
		return 0;
	}

	public void reset() {
		
	}

	public boolean getStopped() {
		return false;
	}

	public boolean getDirection() {
		return false;
	}

	public double getDistance() {
		return 0;
	}

	public double getRate() {
		return 0;
	}

	public void setDistancePerPulse(double distancePerPulse) {
	}

}
