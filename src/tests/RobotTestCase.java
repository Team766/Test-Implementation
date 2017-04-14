package tests;
import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

import org.opencv.core.Core;

import junit.framework.TestCase;
import lib.Actor;
import lib.ConstantsFileReader;
import lib.Scheduler;

public class RobotTestCase extends TestCase{
	public static TestRobotProvider instance;
	
	MyRobot robot;
	
	protected void setUp() throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		ConfigFileReader.fileName = "simConfig.txt";
		ConstantsFileReader.fileName = "simConstants.csv";

		TestRobotProvider robotProvider = new TestRobotProvider();
		RobotProvider.instance = robotProvider;
		RobotTestCase.instance = robotProvider;
		
		Scheduler.getInstance().reset();
		
		robot = null;
		try {
			robot = (MyRobot)Class.forName("com.team766.robot.Robot").asSubclass(MyRobot.class).newInstance();
		} catch (Exception e) {
			System.err.println("Runner: Failed to instatiate Robot\t:(");
			e.printStackTrace();
		}
		robot.robotInit();
	}
	
	protected void disableInit(){
		robot.disabledInit();
	}
	
	protected void disablePeriodic(){
		robot.disabledPeriodic();
	}
	
	protected void teleopInit(){
		robot.teleopInit();
	}
	
	protected void teleopPeriodic(){
		robot.teleopPeriodic();
	}
	
	protected void autonInit(){
		robot.autonomousInit();
	}
	
	protected void autonPeriodic(){
		robot.autonomousPeriodic();
	}
	
	
	/**
	 * Wait for condition or until it times out
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
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		throw new TimeoutException("Waited too long");
	}
	
	public void assertTrueTimed(Callable<Boolean> condition, double timeout) throws Exception{
		wait(timeout, condition);
		assertTrue(condition.call());
	}
	
	protected void step(Class<? extends Actor> act){
		Scheduler.getInstance().getActor(act).step();
	}
	
}
