package org.usfirst.frc.team2526.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Device IDs

	public static final int WINCH_TALON = 1;
	// winch motors

	public static final int LEFT_ALIGN_TALON = 3;
	public static final int RIGHT_ALIGN_TALON = 4;
	// allignment wheels

	public static final int REAR_RIGHT_TALON = 5;
	public static final int REAR_LEFT_TALON = 6;
	public static final int FRONT_RIGHT_TALON = 7;
	public static final int FRONT_LEFT_TALON = 8;
	// drivetrain wheels

	public static final int PCM_MAIN = 9;

	// End CAN IDs

	// Start Pneumatic Channels
	public static final int FLIPPER_RIGHT = 0;
	public static final int FLIPPER_LEFT = 1;
	public static final int WINCH_BRAKE_A = 2;
	public static final int WINCH_BRAKE_B = 3;
	public static final int ALIGNMENT_ARM = 4;
	public static final int STABLE_ELEVATOR_A = 5;
	public static final int STABLE_ELEVATOR_B = 6;
	// End Pneumatic Channels

	// Start DIO Channel
	// End DIO Channels

}
