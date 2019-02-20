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

public class BackLineFollowerCommandV2 extends Command {

  Joystick stick = null;

  public BackLineFollowerCommandV2() {
     // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lineFollowerSubsystem);
    requires(Robot.gyroSubsystem);
    requires(Robot.drivetrainSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    stick = Robot.m_oi.driveStick;

  }

  private static int priorState = 0b000;
  public static boolean disabled = false;
  

  private String getState(int state)
  {
    switch(state)
    {
      case 0b000:  
      case 0b101:
      case 0b111:
        return "Joystick control";
      case 0b010:
        return "Go Straight";
      case 0b110:
        return "move right";
      case 0b011:
        return "move left";
      case 0b100:
        return " move right";
      case 0b001:
        return "move left";
      default:
        return "ignore";
    }
  }

  private boolean trigger = false;

  // Called repeatedly when this Command is scheduled to run
 
  @Override
  protected void execute() {
    disabled = false;
    int currentState = Robot.lineFollowerSubsystem.getBackLineFollowerState();
   // System.out.println("priorState=" + priorState + "  currentState=" + currentState);
   // System.out.println("JoystickX=" + stick.getX());

    if(priorState == currentState){
      System.out.println("No state change");
    }
    else if(currentState == 0b000) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), 0, Robot.gyroSubsystem.getCurrentAngle());
      System.out.println("joystick control");  
    } else if((currentState & 0b100) == 0b100){
      Robot.drivetrainSubsystem.Drive(0, -0.16, 0, 0);
      System.out.println("move left");
      if(!((currentState & 0b010) == 0b010)) {
        Robot.drivetrainSubsystem.Drive(0,-0.16, 0, 0);
        System.out.println("move left");
      }
    } else if((currentState & 0b001) == 0b001){
      Robot.drivetrainSubsystem.Drive(0, 0.16, 0, 0);
      System.out.println("move right");
      if(!((currentState & 0b010) == 0b010)) {
        Robot.drivetrainSubsystem.Drive(0, 0.16, 0, 0);
        System.out.println("move right");
      }
    } else if((currentState & 0b010) == 0b010){
      Robot.drivetrainSubsystem.Drive(0, 0, 0, 0); //-0.16
      System.out.println("move forward");
      disabled = true;
    } else {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getTwist(), Robot.gyroSubsystem.getCurrentAngle());
      System.out.println("joystick control");
    }
    //System.out.println("L=" + !RobotMap.leftSensor.get() + " C=" + !RobotMap.centerSensor.get() + " R=" + !RobotMap.rightSensor.get());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return disabled;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    priorState = 0b000;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    priorState = 0b000;
  }
}