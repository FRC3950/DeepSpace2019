/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {

  Joystick stick = Robot.m_oi.driveStick;

  private static final double Kp = 0.3;
  private static final double Ki = 0.0;
  private static final double Kd = 0.0;



  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrainSubsystem);
    requires(Robot.gyroSubsystem);
    
    // PIDController leftFrontPID =  new PIDController(Kp, Ki, Kd, fLVelocity, leftFront);
    // PIDController rightFrontPID =  new PIDController(Kp, Ki, Kd, rightFrontEncoder, rightFront);
    // PIDController leftBackPID =  new PIDController(Kp, Ki, Kd, leftBackEncoder, leftBack);
    // PIDController rightBackPID =  new PIDController(Kp, Ki, Kd, rightBackEncoder, rightBack);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {


  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getTwist());
    double fLVelocity = Robot.drivetrainSubsystem.frontLeft.getEncoder().getVelocity();
    double fRVelocity =Robot.drivetrainSubsystem.frontRight.getEncoder().getVelocity();
    double bLVelocity =Robot.drivetrainSubsystem.backLeft.getEncoder().getVelocity();
    double bRVelocity = Robot.drivetrainSubsystem.backRight.getEncoder().getVelocity();

    // PIDController leftFrontPID = new PIDController(Kp, Ki, Kd, fLVelocity, Robot.drivetrainSubsystem.frontLeft);
    // PIDController rightFrontPID =  new PIDController(Kp, Ki, Kd, fRVelocity, Robot.drivetrainSubsystem.frontRight);
    // PIDController leftBackPID =  new PIDController(Kp, Ki, Kd, bLVelocity, Robot.drivetrainSubsystem.backLeft);
    // PIDController rightBackPID =  new PIDController(Kp, Ki, Kd, bRVelocity, Robot.drivetrainSubsystem.backRight);

    //Robot.drivetrainSubsystem.driveCartesian(stick.getY(), stick.getX(), stick.getTwist());
    //Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getTwist());
    // System.out.println("fL" + Robot.drivetrainSubsystem.frontLeft.getBusVoltage());
    // System.out.println("bL" + Robot.drivetrainSubsystem.backLeft.getBusVoltage());
    // System.out.println("fR" + Robot.drivetrainSubsystem.frontRight.getBusVoltage());    
    // System.out.println("bR" + Robot.drivetrainSubsystem.backRight.getBusVoltage());
    // if(Robot.robotLiftSubsystem.backLeftLiftSolenoid.get() == Value.kForward) {
    //   Robot.robotLiftSubsystem.liftMotor.set(stick.getY());
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
