/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RobotLiftMotorCommand extends Command {

  //Joystick stick = Robot.m_oi.driveStick;

  double speed = 0;
  Timer timer2 = new Timer();
  boolean finished = false;

  public RobotLiftMotorCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer2.reset();
    timer2.start();
    finished = false;
    // System.out.println("Robot Lift Motor Initialize");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(timer2.get() <= .5) {
      Robot.robotLiftSubsystem.liftMotor.set(-0.5);
      finished = false;
    } else {
      timer2.stop();
      Robot.robotLiftSubsystem.liftMotor.set(0);
      finished = true;
    }
    // System.out.println("Robot Lift Motor Execute");
  // if((Robot.robotLiftSubsystem.backLeftLiftSolenoid.get() == Value.kForward) && (Robot.robotLiftSubsystem.backRightLiftSolenoid.get() == Value.kForward)){
  //   Robot.robotLiftSubsystem.liftMotor.set(stick.getY());
  //   }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    finished = false;
 // Robot.robotLiftSubsystem.liftMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
