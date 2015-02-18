package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoPilotDrive extends Command {

	double distance;
    public AutoPilotDrive(double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetCurrentPosition();
    	//Robot.driveTrain.driveForward(0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (distance > 0)
    		Robot.driveTrain.driveForward(0.3);
    	else
    		Robot.driveTrain.driveBackward(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double error = distance - Robot.driveTrain.getCurrentPosition();
    	SmartDashboard.putNumber("Drive Error ", error);
        return error < 10;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
