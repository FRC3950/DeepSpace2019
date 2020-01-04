/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DrivetrainSubsystem extends Subsystem {
  
  final int frontLeftChannel = 3;
  final int backLeftChannel = 2;
  final int frontRightChannel = 1;
  final int backRightChannel = 4;

  
  public CANSparkMax frontLeft = new CANSparkMax(frontRightChannel, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax backLeft = new CANSparkMax(backRightChannel, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax frontRight = new CANSparkMax(frontLeftChannel, CANSparkMaxLowLevel.MotorType.kBrushless);
  public CANSparkMax backRight = new CANSparkMax(backLeftChannel, CANSparkMaxLowLevel.MotorType.kBrushless);

  MecanumDrive drivetrain;

  // AHRS navx;

  // double startingAngle = 0.0;
 
//    DifferentialDrive drivetrain;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  @Override
  public void initDefaultCommand() {

     //navx = RobotMap.ahrs;


    // setStartingAngle();

    // frontLeft.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontLeft.setSensorPhase(false);
    // frontRight.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 0, 0);
    // frontRight.setSensorPhase(false);

    // SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
    // SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);

     backLeft.setInverted(true);
     backRight.setInverted(true);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  
    frontLeft.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);

    // frontLeft.setSmartCurrentLimit(50);
    // backLeft.setSmartCurrentLimit(55);
    // frontRight.setSmartCurrentLimit(50);
    // backRight.setSmartCurrentLimit(55);

    //drivetrain.setSafetyEnabled(true);
    //  drivetrain = new DifferentialDrive(left, right);
    
    drivetrain.setSafetyEnabled(false);

    setDefaultCommand(new DriveCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Drive(double ySpeed, double xSpeed, double zRotation){
    double x, y, z;
    x = -ySpeed;
    y = -xSpeed;
    z = -zRotation;
    if(y<0.25 && y>-0.25) y = 0;
    if(x<0.25 && x>-0.25) x = 0;
    if(z<0.2 && z>-0.2) z = 0;
    // if (y < 0) y = -(y*y); else 
    y = y*y*y;
    // if (x < 0) x = -(x*x); else 
    x = x*x*x;
    //System.out.println("x=" + x + "  y=" + y + "  z=" + z + "  gyroAngle=" + gyroAngle);
    drivetrain.driveCartesian(y, x, .6 * z);

  }
  // public void driveCartesian(double ySpeed, double xSpeed, double zRotation){
  //   double y, x, z;
  //   x = -ySpeed;
  //   y = -xSpeed;
  //   z = -zRotation;
  //   if(y<0.35 && y>-0.35) y = 0;
  //   if(x<0.35 && x>-0.35) x = 0;
  //   if(z<0.35 && z>-0.35) z = 0;
  //   // if (y < 0) y = -(y*y); else y = y*y;
  //   // if (x < 0) x = -(x*x); else x = x*x;
  //   System.out.println("x=" + x + "  y=" + y + "  z=" + z);
  //   drivetrain.driveCartesian(y, x, z);

  //  }
//  public double getAngle() {
//    return RobotMap.ahrs.getAngle() - startingAngle;
//    //math to get angle from navx
//  }
//  public void setStartingAngle() {
//    startingAngle = RobotMap.ahrs.getAngle();
//    //sets angle of navx
// }
 
// public void Drive(double y, double twist){
//  drivetrain.arcadeDrive(-y, twist);
//  }
  public double getFrontLeftEncoder(){
    return frontLeft.getEncoder().getPosition();
  }
  public double getBackLeftEncoder(){
    return backLeft.getEncoder().getPosition();
  }
  public double getFrontRightEncoder(){
    return frontRight.getEncoder().getPosition();
  }
  public double getBackRightEncoder(){
    return backRight.getEncoder().getPosition();
  }
  public double getAverageEncoder() {
    return (frontLeft.getEncoder().getPosition() + backLeft.getEncoder().getPosition() + frontRight.getEncoder().getPosition() + backRight.getEncoder().getPosition()) /4;
  }
  public void setPositionZero(){
    backLeft.getEncoder().setPosition(0.0);
    frontLeft.getEncoder().setPosition(0.0);
    backRight.getEncoder().setPosition(0.0);
    frontRight.getEncoder().setPosition(0.0);
  }
  public void setSetpoint(int setpoint)
{
    double x = setpoint;
}





}
