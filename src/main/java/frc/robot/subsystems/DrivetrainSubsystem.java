/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DrivetrainSubsystem extends Subsystem {
  WPI_TalonSRX frontLeft;
  WPI_TalonSRX backLeft;
  WPI_TalonSRX frontRight;
  WPI_TalonSRX backRight;

//  MecanumDrive drivetrain;
    DifferentialDrive drivetrain;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    frontLeft = RobotMap.frontLeft;
    backLeft = RobotMap.backLeft;
    frontRight = RobotMap.frontRight;
    backRight = RobotMap.backRight;

    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);

    // frontLeft.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontLeft.setSensorPhase(false);
    // frontRight.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontRight.setSensorPhase(false);

    SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
    SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);

  //  drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
      drivetrain = new DifferentialDrive(left, right);

    setDefaultCommand(new DriveCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

//  public void Drive(double ySpeed, double xSpeed, double zRotation){
//    drivetrain.driveCartesian(ySpeed, xSpeed, zRotation);
//  }

public void Drive(double y, double twist){
  drivetrain.arcadeDrive(-y, twist);
  }
}
