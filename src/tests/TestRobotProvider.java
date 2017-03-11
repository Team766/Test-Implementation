package tests;
import interfaces.AnalogInputReader;
import interfaces.CameraInterface;
import interfaces.CameraReader;
import interfaces.DigitalInputReader;
//import interfaces.CameraReader;
import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;

public class TestRobotProvider extends RobotProvider{

	@Override
	public SpeedController getMotor(int index) {
		if(motors[index] == null)
			motors[index] = new Talon(index);
		return motors[index];
	}

	@Override
	public EncoderReader getEncoder(int index1, int index2) {
		if(encoders[index1] == null)
			encoders[index1] = new Encoder(index1, index2);
		return encoders[index1];
	}

	@Override
	public SolenoidController getSolenoid(int index) {
		if(solenoids[index] == null)
			solenoids[index] = new Solenoid(index);
		return solenoids[index];
	}

	@Override
	public GyroReader getGyro(int index) {
		if(gyros[0] == null)
			gyros[0] = new Gyro();
		return gyros[0];
	}

	@Override
	public CameraReader getCamera(String id, String value) {
		if(!cams.containsKey(id))
			cams.put(id, new Camera());
		return cams.get(id);
	}

	@Override
	public JoystickReader getJoystick(int index) {
		if(joysticks[index] == null)
			joysticks[index] = new Joystick(index);
		return joysticks[index];
	}
	
	@Override
	public DigitalInputReader getDigitalInput(int index) {
		if(digInputs[0] == null)
			digInputs[0] = new DigitalInput();
		return digInputs[0];
	}

	@Override
	public CameraInterface getCamServer() {
		return null;
	}
	
	@Override
	public AnalogInputReader getAnalogInput(int index) {
		if(angInputs[0] == null)
			angInputs[0] = new AnalogInput();
		return angInputs[0];
	}


}
