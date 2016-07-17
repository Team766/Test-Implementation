package tests;
import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;
import junit.framework.TestCase;

public class RobotTestCase extends TestCase{
	public static TestRobotProvider instance;
	
	protected void setUp() throws Exception {
		ConfigFileReader.fileName = "src/config.txt";

		TestRobotProvider robotProvider = new TestRobotProvider();
		RobotProvider.instance = robotProvider;
		RobotTestCase.instance = robotProvider;
		
		MyRobot robot = null;
		try {
			robot = (MyRobot)Class.forName("com.team766.robot.Robot").asSubclass(MyRobot.class).newInstance();
		} catch (Exception e) {
			System.err.println("Runner: Failed to instatiate Robot\t:(");
			e.printStackTrace();
		}
		robot.robotInit();
	}
}
