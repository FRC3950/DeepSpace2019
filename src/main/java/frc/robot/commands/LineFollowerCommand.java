/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LineFollowerCommand extends Command {

    Joystick stick = Robot.m_oi.driveStick;
    AHRS ahrs = null;

  public LineFollowerCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Center Light =" + RobotMap.centerLight.get());
    boolean centerLight = RobotMap.centerLight.get();
    boolean leftLight = RobotMap.leftLight.get();
    boolean rightLight = RobotMap.rightLight.get();
// The zeros in the If statement need to be changed 
    if ((!centerLight && !leftLight && !rightLight) || (centerLight && leftLight && rightLight)) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (stick.getTwist()), 0 );
      //end
    }
    else if (!leftLight && !rightLight) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(),(stick.getTwist()), 0);
      //move forward 
    }
    else if (leftLight && !rightLight){
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (Math.abs(stick.getTwist() * 1)), 0);
      //rotate clockwise
    }
    else if (rightLight && !leftLight){
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (Math.abs(stick.getTwist() * -1)), 0);
      //rotate counter clockwise
    }
    //The above if statement tells the robot what to do depending on which sensors are active

    Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (.75*stick.getTwist()), 0);
    //Might not need the .75 
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
