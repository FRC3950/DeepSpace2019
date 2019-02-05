/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.kauailabs.navx.frc.AHRS;
//import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DrivetrainSubsystem extends Subsystem {
  
  final int frontLeftChannel = 0;
  final int backLeftChannel = 1;
  final int frontRightChannel =2;
  final int backRightChannel = 3;
  
  public CANSparkMax frontLeft = new CANSparkMax(frontLeftChannel, MotorType.kBrushless);
  public CANSparkMax backLeft = new CANSparkMax(backLeftChannel, MotorType.kBrushless);
  public CANSparkMax frontRight = new CANSparkMax(frontRightChannel, MotorType.kBrushless);
  public CANSparkMax backRight = new CANSparkMax(backRightChannel, MotorType.kBrushless);

  MecanumDrive drivetrain;

  AHRS navx;

  double startingAngle = 0.0;
 
//    DifferentialDrive drivetrain;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {

     navx = RobotMap.ahrs;

    // frontLeft.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontLeft.setSensorPhase(false);
    // frontRight.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontRight.setSensorPhase(false);

   //  SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
   // SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    //drivetrain.setSafetyEnabled(true);
  //    drivetrain = new DifferentialDrive(left, right);
    
    drivetrain.setSafetyEnabled(false);

    setDefaultCommand(new DriveCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Drive(double ySpeed, double xSpeed, double zRotation, double gyroAngle){
    drivetrain.driveCartesian(ySpeed, xSpeed, zRotation, gyroAngle);
  }
 public double getAngle() {
   return navx.getAngle() - startingAngle; 
 }
 public void setStartingAngle() {
   startingAngle = navx.getAngle();
}
 
//public void Drive(double y, double twist){
//  drivetrain.arcadeDrive(-y, twist);
//  }
}
