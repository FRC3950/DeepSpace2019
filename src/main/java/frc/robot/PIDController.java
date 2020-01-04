/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Add your docs here.
 */
public class PIDController extends PIDSubsystem {
  /**
   * Add your docs here.
 * @param frontLeft
 * @param fLVelocity
 * @param kd
 * @param ki
 * @param kp
   */
  public PIDController(double kp, double ki, double kd, double velocity, CANSparkMax frontLeft) {
    // Intert a subsystem name and PID values here
    super("DrivetrainSubsystem", 1, 0, 0);
    final double Kp = 0.3;
    // edit the p value
    final double Ki = 0.0;
    final double Kd = 0.0;
    
    double fLVelocity =Robot.drivetrainSubsystem.frontLeft.getEncoder().getVelocity();   
    double fRVelocity =Robot.drivetrainSubsystem.frontRight.getEncoder().getVelocity();
    double bLVelocity =Robot.drivetrainSubsystem.backLeft.getEncoder().getVelocity();
    double bRVelocity = Robot.drivetrainSubsystem.backRight.getEncoder().getVelocity();

    PIDController leftFrontPID = new PIDController(Kp, Ki, Kd, fLVelocity, Robot.drivetrainSubsystem.frontLeft);
    PIDController rightFrontPID =  new PIDController(Kp, Ki, Kd, fRVelocity, Robot.drivetrainSubsystem.frontRight);
    PIDController leftBackPID =  new PIDController(Kp, Ki, Kd, bLVelocity, Robot.drivetrainSubsystem.backLeft);
    PIDController rightBackPID =  new PIDController(Kp, Ki, Kd, bRVelocity, Robot.drivetrainSubsystem.backRight);

    leftFrontPID.enable();
    rightBackPID.enable();
    rightFrontPID.enable();
    rightBackPID.enable();

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
