package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.RobotValues;
import org.usfirst.frc.team2526.robot.commands.alignment.CloseArm;
import org.usfirst.frc.team2526.robot.commands.alignment.OpenArm;
import org.usfirst.frc.team2526.robot.commands.alignment.StartAlign;
import org.usfirst.frc.team2526.robot.commands.drive.PIDAutoPilotDrive;
import org.usfirst.frc.team2526.robot.commands.elevator.SetElevatorPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FlipRC extends CommandGroup {

    public FlipRC() {
    	addParallel(new StartAlign(false));
    	addSequential(new SetElevatorPosition(RobotValues.RC_HUG*RobotValues.MAX_POSITION));
    	addSequential(new OpenArm());
    	// If arms close soon after, check subsystem default command
    	addSequential(new PIDAutoPilotDrive(-400, 2));
    	
    	
    	addParallel(new StartAlign(true));
    	addParallel(new CloseArm());
    	addSequential(new WaitCommand(0.2));
    }
    
}
