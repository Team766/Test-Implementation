package tests;
import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

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
	
	/**
	 * Wait for condition or until it timesout
	 * 
	 * @param timeout Seconds
	 * @param condition
	 * @throws Exception
	 */
	public void wait(double timeout, Callable<Boolean> condition) throws Exception{
		double endTime = System.currentTimeMillis() + (timeout * 1000);
		while(endTime > System.currentTimeMillis()){
			if(condition.call())
				return;
		}
		throw new TimeoutException("Waited too long");
	}
}
