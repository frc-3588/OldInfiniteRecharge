// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Servo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

/**
 *
 */
public class Chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    private CANEncoder leftFrontEncoder;
    private CANEncoder leftRearEncoder;
    private CANEncoder rightFrontEncoder;
    private CANEncoder rightRearEncoder;


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Servo cameraServo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANSparkMax leftFrontMotor;
    CANSparkMax leftRearMotor;
    CANSparkMax rightFrontMotor;
    CANSparkMax rightRearMotor;
    
    private SpeedControllerGroup leftSpeedControllerGroup;
    private SpeedControllerGroup rightSpeedControllerGroup;
    private DifferentialDrive myDifferentialDrive;

    public final double FORWARDDISTANCE = 40.0;
    public final double BACKWARDSDISTANCE = 20.0;
    private double winchCircumference = 2 * Math.PI;
    private double countsPerRevolution = 42;
    public final double NORMAL = 0.5;
    public final double STOP = 0.0;
    public final double CAMERASERVOINCREMENT = 0.2;
    public final double CAMERASERVODECREMENT = CAMERASERVOINCREMENT;
    public final double MAXSERVOPOSITION = 1.0;
    public final double MINSERVOPOSITION = 0.0;

    public Chassis() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
cameraServo = new Servo(0);
addChild("CameraServo",cameraServo);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    leftFrontMotor = new CANSparkMax(12, MotorType.kBrushless);
    leftRearMotor = new CANSparkMax(13, MotorType.kBrushless);
    rightFrontMotor = new CANSparkMax(14, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(15, MotorType.kBrushless);

    leftSpeedControllerGroup = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    rightSpeedControllerGroup = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
    myDifferentialDrive = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup);

    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTB

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void setTankDrivePower(double leftPower, double rightPower){
        myDifferentialDrive.tankDrive(-1*leftPower, -1*rightPower);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public double getLFEncoderPosition(){
        return leftFrontEncoder.getPosition();
    }
    public double getLREncoderPosition(){
        return leftRearEncoder.getPosition();
    }
    public double getRFEncoderPosition(){
        return rightFrontEncoder.getPosition();
    }
    public double getRREncoderPosition(){
        return rightRearEncoder.getPosition();
    }
    public double getAverageEncoderValue(){
        return (leftFrontEncoder.getPosition() + rightFrontEncoder.getPosition() + rightRearEncoder.getPosition() + leftRearEncoder.getPosition())/4;
    }
    public double getTotalCounts(double distance){
        return (distance/winchCircumference) * countsPerRevolution;
    }
    public void setCameraServoPosition(double position){
        cameraServo.setPosition(position);
    }
    public double getCameraServoPosition(){
        return cameraServo.getPosition();
    }
}

