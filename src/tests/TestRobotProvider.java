package tests;
import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;

public class TestRobotProvider extends RobotProvider{
	
	private SpeedController[] motors = new SpeedController[10];
	private EncoderReader[] encoders = new EncoderReader[10];
	private SolenoidController[] solenoids = new SolenoidController[10];
	private GyroReader[] gyros = new GyroReader[5];
	private JoystickReader[] joysticks = new JoystickReader[3];

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
		if(gyros[index] == null)
			gyros[index] = new Gyro();
		return gyros[index];
	}

	@Override
	public JoystickReader getJoystick(int index) {
		if(joysticks[index] == null)
			joysticks[index] = new Joystick(index);
		return joysticks[index];
	}

}
