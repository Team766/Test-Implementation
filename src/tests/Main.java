package tests;
import interfaces.ConfigFileReader;
import interfaces.MyRobot;
import interfaces.RobotProvider;


public class Main {
	public static void main(String[] args){
		ConfigFileReader.fileName = "src/config.txt";
		
		TestRobotProvider robotProvider = new TestRobotProvider();
		RobotProvider.instance = robotProvider;
		RobotTestCase.instance = robotProvider;
		
		MyRobot robot = null;
		try {
			robot = (MyRobot)Class.forName(args[0]).asSubclass(MyRobot.class).newInstance();
		} catch (Exception e) {
			System.err.println("Runner: Failed to instatiate Robot\t:(");
			e.printStackTrace();
		}
		robot.robotInit();		
	}
}
