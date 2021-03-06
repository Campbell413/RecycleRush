package org.usfirst.frc.team2526.robot;

public class RobotValues {
	public final static int WINCH_TOLERANCE = 150;

	public static final double FLOOR = 0, // Calibrated
			TOTE_ONE_GRAB = 0.21575,
			TOTE_TWO = 0.45,
			AUTO_RC = 0.451,
			SECOND_THIRD = 0.465,
			SCORING = 0.11775, 
			RC_TOP_TOTE = 0.49025,
			RC_HUG = 0.21175,
			CHUTE = 0.8195,
			CHUTE_STACK = 0.46275,
			STEP = 0.11775,
			ARM_SAFETY = 0.29;
	

	public static double MAX_POSITION = 4000;
	
	public static final int RC_TO_TOTE_DISTANCE = 1000;
	public static final int TOTE_TO_OP_TOTE_DISTANCE = 1500;
	public static final int TOTE_TO_AUTOZONE_DISTANCE = 1500;
	
	public static final double DRIVE_P = 0.4;
	public static final double DRIVE_I = 0.01;
	public static final double DRIVE_D = 11;
	
	public static final double WINCH_P = 1;
	public static final double WINCH_I = 0;
	public static final double WINCH_D = 0;
	public static final double WINCH_RAMP = 1;
	
	public static final double BL_180 = 3.9625;
	public static final double FR_180 = 2.65;
	public static final double BR_180 = 3.485;
	public static final double FL_180 = 2.84;
	
	public static final double DRIVE_CURVE = 2;
}
