package org.usfirst.frc.team2526.robot.commands.calibrations;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateElevatorMax extends Command {

    public CalibrateElevatorMax() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.usePID(false);
    	Robot.elevator.moveUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.isAtTop();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.calibrateMax();
    	Robot.elevator.stopElevator();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.stopElevator();
    }
}
