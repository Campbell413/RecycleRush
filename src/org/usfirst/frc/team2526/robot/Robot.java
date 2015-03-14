
package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.autonomous.Autonomous;
import org.usfirst.frc.team2526.robot.autonomous.RCAutonomous;
import org.usfirst.frc.team2526.robot.autonomous.ToteAutonomous;
import org.usfirst.frc.team2526.robot.commands.vision.VisionCommunications;
import org.usfirst.frc.team2526.robot.subsystems.AlignmentArms;
import org.usfirst.frc.team2526.robot.subsystems.AlignmentWheels;
import org.usfirst.frc.team2526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2526.robot.subsystems.Elevator;
import org.usfirst.frc.team2526.robot.subsystems.Flipper;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command autonomousCommand;
	
	SendableChooser autoChooser = new SendableChooser();
	
	public static DriveTrain driveTrain;
	public static AlignmentWheels alignmentWheels;
	public static AlignmentArms alignmentArms;
	public static Elevator elevator;
	public static Flipper flipper;
	public static OI oi;
	
	public static VisionCommunications vision;


    public void robotInit() {
    	enableDebug(true);
    	
    	vision = new VisionCommunications();
    	
		new Compressor(RobotMap.PCM_MAIN).start();
	
		driveTrain = new DriveTrain();
		alignmentWheels = new AlignmentWheels();
		alignmentArms = new AlignmentArms();
		elevator = new Elevator();
		flipper = new Flipper();
		
		oi = new OI();
		
		autoChooser.addDefault("One Tote Out", new ToteAutonomous());
		autoChooser.addObject("One RC", new RCAutonomous());
		autoChooser.addObject("Two tote RC", new Autonomous());
		
		SmartDashboard.putData("AutoChooser", autoChooser);
		
		if (isDebug()) {
			SmartDashboard.putData(driveTrain);
			SmartDashboard.putData(alignmentWheels);
			SmartDashboard.putData(elevator);
			SmartDashboard.putData(flipper);
		}
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
    	
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    
        Scheduler.getInstance().run();
        if (isDebug()) SmartDashboard.putNumber("Current Position", elevator.getPosition());
        
        Robot.elevator.update(); 
        Robot.driveTrain.update();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    
    /* Debug Mode */
    private static boolean debugMode;
    
    public boolean isDebug() {
    	return debugMode;
    }
    
    public static void enableDebug(boolean debug) {
    	debugMode = debug;
    }
}
