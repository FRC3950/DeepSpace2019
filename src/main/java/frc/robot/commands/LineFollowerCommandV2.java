/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LineFollowerCommandV2 extends Command implements PIDOutput{

  Joystick stick = null; //Robot.m_oi.driveStick;

  public LineFollowerCommandV2() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lineFollowerSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  private static int priorState = 0b000;
  private static boolean prior_centerCamera = false;
  private static boolean prior_leftCamera = false;
  private static boolean prior_rightCamera = false;
  public static boolean disabled = false;
  

  private String getState(int state)
  {
    switch(state)
    {
      case 0b000:  
      case 0b101:
      case 0b111:
        Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getTwist(),Robot.drivetrainSubsystem.getAngle());
        return "Joystick control";
      case 0b010:
        return "Go Straight";
      case 0b110:
        Robot.drivetrainSubsystem.Drive(0, 0.75, -0.25, 0);
        return "move right and go straight";
      case 0b011:
        Robot.drivetrainSubsystem.Drive(0, 0.75, 0.25, 0);
        return "move left and go straight";
      case 0b100:
        return " move right and go straight";
      case 0b001:
        Robot.drivetrainSubsystem.Drive(-0.75, 0.75, 0.25, 0);
        return "move left and go striaght";
      default:
        return "ignore";
    }
  }

  private boolean trigger = false;

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int currentState = Robot.lineFollowerSubsystem.getLineFollowerState();
    System.out.println("priorState=" + priorState + "  currentState=" + currentState);

    if(priorState == currentState){
      //  System.out.println("No state change");
    }
    else if(currentState == 0b000) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getTwist(), Robot.drivetrainSubsystem.getAngle());
      System.out.println("joystick control");  
    } else if((currentState & 0b100) == 0b100){
      Robot.drivetrainSubsystem.Drive(0.75, 0.75, -0.25, 0);
      System.out.println("move right and go straight");
      if(!((currentState & 0b010) == 0b010)) {
        Robot.drivetrainSubsystem.Drive(0, 0.75, 0, 0);
        System.out.println("move right");
      }
    } else if((currentState & 0b001) == 0b001){
      Robot.drivetrainSubsystem.Drive(-0.75, 0.75, 0.25, 0);
      System.out.println("move left and go straight");
      if(!((currentState & 0b010) == 0b010)) {
        Robot.drivetrainSubsystem.Drive(0, 0.75, 0, 0);
        System.out.println("move left");
      }
    } else if((currentState & 0b101) == 0b101){
      Robot.drivetrainSubsystem.Drive(0, 0.75, 0, 0);
      System.out.println("move forward");
    } else {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), stick.getTwist(), Robot.drivetrainSubsystem.getAngle());
      System.out.println("joystick control");
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
    priorState = 0b000;
    prior_centerCamera = false;
    prior_leftCamera = false;
    prior_rightCamera = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    priorState = 0b000;
    prior_centerCamera = false;
    prior_leftCamera = false;
    prior_rightCamera = false;
  }
  @Override
  public void pidWrite(double output) {

  }
}
