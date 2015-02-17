package org.usfirst.frc.team2526.robot.commands.alignment;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class StartAlign extends SimpleCommand {

    public StartAlign() {
        super(Robot.alignmentWheels);
    }

    protected void initialize() {
    	Robot.alignmentWheels.startAlign();
    }
 

    protected void end() {
    	Robot.alignmentWheels.stopAlign();
    }

}
