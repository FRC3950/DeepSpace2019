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

public class BackLineRecognizerCommandV2 extends Command {
  Joystick stick = null;

  public BackLineRecognizerCommandV2() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lineFollowerSubsystem);
    requires(Robot.drivetrainSubsystem);
  //  System.out.println("BackLineRecognizerCommandV2.BackLineRecognizerCommandV2");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("BackLineRecognizerCommandV2.initialize");
    stick = Robot.m_oi.driveStick;
    disabled = false;
  }

  public static boolean disabled = false;
  private static int lastLineFollowerState = 0b000;

  // Called repeatedly when this Command is scheduled to run
 
  @Override
  protected void execute() {
    int currentState = Robot.lineFollowerSubsystem.getBackLineFollowerState();

    if(currentState == 0b000) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getZ(), Robot.gyroSubsystem.getCurrentAngle());
//      System.out.println("joystick control");  
      lastLineFollowerState = currentState;
    } else {
      System.out.println("BackLineRecognizerCommandV2.executeELSE");
      disabled = true;
    }
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
   // System.out.println("BackLineRecognizerCommandV2.isFinished");
    return disabled;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("BackLineRecognizerCommandV2.end");
   lastLineFollowerState = Robot.lineFollowerSubsystem.getBackLineFollowerState();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("BackLineRecognizerCommandV2.interrupted");
  }
}
