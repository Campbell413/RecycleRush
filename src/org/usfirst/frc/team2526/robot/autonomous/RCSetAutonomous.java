package org.usfirst.frc.team2526.robot.autonomous;

import org.usfirst.frc.team2526.robot.commands.ExtendRCGrabber;
import org.usfirst.frc.team2526.robot.commands.RetractRCGrabber;
import org.usfirst.frc.team2526.robot.commands.drive.TimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RCSetAutonomous extends CommandGroup {
    
	
    public  RCSetAutonomous() {
    	
    	addParallel(new ExtendRCGrabber());
    	addSequential(new WaitCommand(7));
    	addSequential(new TimedDrive(0.6, false));
    	addSequential(new TimedDrive(2.8, true));
    	addSequential(new RetractRCGrabber());
    }
}
