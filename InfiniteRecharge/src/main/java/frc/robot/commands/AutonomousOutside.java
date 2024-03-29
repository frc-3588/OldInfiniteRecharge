// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class AutonomousOutside extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    // private final double Robot.chassis.NORMAL = 0.5;
    // private final double Robot.chassis.STOP = 0.0;

    // positional variables (data)
    private final double VERTICAL_MAX_ROTATIONS = Robot.chassis.getTotalCounts(Robot.chassis.FORWARDDISTANCE);

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousOutside() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.chassis.setTankDrivePower(Robot.chassis.NORMAL, Robot.chassis.NORMAL);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        // will execute everything in order, so no need to repeat execute.
        // return true;
        if (Robot.chassis.getAverageEncoderValue() < VERTICAL_MAX_ROTATIONS) {
            return false;
        } else {
            return true;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        // Robot.chassis.STOP all motors. Command ended.
        Robot.chassis.setTankDrivePower(Robot.chassis.STOP, Robot.chassis.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
