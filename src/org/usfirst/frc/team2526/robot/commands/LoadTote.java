package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.commands.alignment.OpenArm;
import org.usfirst.frc.team2526.robot.commands.elevator.SetElevatorPosition;
import org.usfirst.frc.team2526.robot.commands.elevator.StabilizeTote;
import org.usfirst.frc.team2526.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LoadTote extends CommandGroup {
    
    public  LoadTote() {
    	super("Load Tote");
    	addParallel(new OpenArm());
    	//addSequential(new WaitCommand(0.4));
        addSequential(new SetElevatorPosition(Elevator.GRAB));
        addSequential(new WaitCommand(0.3));
        addParallel(new StabilizeTote());
        //addSequential(new StopAlign());
    	addSequential(new WaitCommand(0.35));
    	addSequential(new SetElevatorPosition(Elevator.SCORING));
    	
    }
    
    
}
