/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FrontLineRecognizerCommandV2 extends Command {

  Joystick stick = null;

  public FrontLineRecognizerCommandV2() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.gyroSubsystem);
    requires(Robot.drivetrainSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    stick = Robot.m_oi.driveStick;
  }

  public static boolean disabled = false;
  private static int lastLineFollowerState = 0b000;

  // Called repeatedly when this Command is scheduled to run
 
  @Override
  protected void execute() {
    disabled = false;
    int currentState = Robot.lineFollowerSubsystem.getFrontLineFollowerState();

    if(currentState == 0b000) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getZ(), Robot.gyroSubsystem.getCurrentAngle());
      System.out.println("joystick control");  
      lastLineFollowerState = currentState;
    } else {
      disabled = true;
    }
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return disabled;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
   lastLineFollowerState = Robot.lineFollowerSubsystem.getFrontLineFollowerState();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
