package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.elevator.HoldElevator;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	public static double FLOOR = 0, GRAB = 300, SCORING = 700, TOTE = 1800;

	public CANTalon winch;

	public DoubleSolenoid brakeSolenoid, stabilizeSolenoid;

	public Elevator() {
		super("Elevator");

		brakeSolenoid = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.WINCH_BRAKE_A, RobotMap.WINCH_BRAKE_B);
		stabilizeSolenoid = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.STABLE_ELEVATOR_A, RobotMap.STABLE_ELEVATOR_B);

		winch = new CANTalon(RobotMap.WINCH_TALON);
		
		winch.changeControlMode(CANTalon.ControlMode.Position);
		winch.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		winch.reverseOutput(true);
		
		SmartDashboard.putNumber("P", 1);
		SmartDashboard.putNumber("I", 0);
		SmartDashboard.putNumber("D", 0);
		SmartDashboard.putNumber("F", 0);
		SmartDashboard.putNumber("RAMP", 1);
		
		updatePID();
		

		SmartDashboard.putNumber("maxPosition", 6000);
		SmartDashboard.putNumber("setPosition", 1000);
	}

	public void updatePID() {
		winch.setPID(SmartDashboard.getNumber("P", 1),
				SmartDashboard.getNumber("I", 0), 
				SmartDashboard.getNumber("D", 0),
				SmartDashboard.getNumber("F", 0), 360,
				SmartDashboard.getNumber("RAMP", 1), 0);
	}

	public boolean isAtTop() {
		return winch.isRevLimitSwitchClosed();
	}

	public boolean isAtBottom() {
		return winch.isFwdLimitSwitchClosed();
	}

	public boolean isAtTarget() {
		return Math.abs(winch.getEncPosition() - winch.getSetpoint()) < 150;
	}

	public void calibrateMin() {
		winch.setPosition(0);
	}

	public void calibrateMax() {
		SmartDashboard.putNumber("maxPosition", winch.getEncPosition());
	}
	
	public void prepareMotor() {
		if (!winch.isControlEnabled()) {
			winch.enableControl();
		}
		
		if (brakeSolenoid.get() == DoubleSolenoid.Value.kReverse) {
			releaseBrake();
		}
	}

	public double getPosition() {
		return winch.getEncPosition();
	}

	public boolean moveToPositionTicks(double position) {
		prepareMotor();
		double maxPosition = SmartDashboard.getNumber("maxPosition");
		if (position < maxPosition && position > 0) {
			winch.set(position);
			return true;
		}
		return false;
	}

	public void setToSmartValue() {
		moveToPositionTicks(SmartDashboard.getNumber("setPosition"));
	}
	
	public void moveUp() {
		winch.set(SmartDashboard.getNumber("maxPosition"));
	}

	public void moveDown() {
		winch.set(0);
	}

	public void stopElevator() {
		winch.disableControl();
	}

	public void applyBrake() {
		brakeSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void releaseBrake() {
		brakeSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void stabilizeTote() {
		stabilizeSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void releaseTote() {
		stabilizeSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new HoldElevator());
	}

	public void updateCalibration() {
		if (isAtTop())
			calibrateMax();
		if (isAtBottom())
			calibrateMin();
	}
}
