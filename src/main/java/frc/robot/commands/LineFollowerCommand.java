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

//    Joystick stick = Robot.m_oi.driveStick;
//    AHRS ahrs = null;

  public LineFollowerCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
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
        return "Joystick control";
      case 0b010:
        return "Go Straight";
      case 0b110:
        return "Rotate Counterclockwise and go straight";
      case 0b011:
        return "Rotate clockwise and go straight";
      case 0b111:
        return "Joystick control";
      case 0b100:
        return "rotate counterclockwise, move right, and move forward";
      case 0b001:
        return "rotate clockwise, move left, and move forward";
      default:
        return "ignore";
    }
  }

  
  private boolean trigger = false;

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(trigger == false) {
      Robot.ultrasonicSubsystem.startTrigger();
      trigger = true;
      return;
    }
    
    int currentState = Robot.lineFollowerSubsystem.getLineFollowerState();
    System.out.println("priorState=" + priorState + "  currentState=" + currentState);
    double leftDistance = Robot.ultrasonicSubsystem.getLeftDistance();
    if(leftDistance != -1.0) {
      System.out.println("leftDistance=" + leftDistance);
      disabled = true;
      trigger = false;
      Robot.ultrasonicSubsystem.resetTrigger();
    }
     /*  if(priorState != currentState){
      System.out.println(getState(priorState) + " --> " + getState(currentState));
    }
    if(priorState == currentState){
      //  System.out.println("No state change");
    }
    else if(currentState == 0b000) {
      System.out.println("joystick control");  
    } else if((currentState & 0b100) == 0b100){
      System.out.println("move forward and rotate counterclockwise");
      if(!((currentState & 0b010) == 0b010)) {
        System.out.println("move right");
      }
    } else if((currentState & 0b001) == 0b001){
      System.out.println("move forward and rotate counterclockwise");
      if(!((currentState & 0b010) == 0b010)) {
        System.out.println("move left");
      }
    } else if((currentState & 0b101) == 0b101){
      System.out.println("move forward");
    } else {
      System.out.println("joystick control");
    } */

    // if((prior_centerCamera == centerCamera) && (prior_leftCamera == leftCamera) && (prior_rightCamera == rightCamera)){
    
    //   //  System.out.println("No state change");
    // } else if(!(centerCamera || leftCamera || rightCamera)){
    //   System.out.println("joystick control");  
    //   //joystick control
    // } else if(leftCamera && !rightCamera){
    //   System.out.println("move forward and rotate counterclockwise");
    //     //move forward and rotate counterclockwise
    //   if(centerCamera == false){
    //     System.out.println("move right");
    //       //move right
    //   }
    // } else if(!leftCamera && rightCamera){
    //   System.out.println("move forward and rotate clockwise");
    //       //move forward and rotate clockwise
    //   if(centerCamera == false){
    //     System.out.println("move left");
    //         //move left
    //   }
    // } else if(leftCamera && !centerCamera && rightCamera){
    //   System.out.println("move forward");
    //         //move forward
    // } else {
    //   System.out.println("joystick control");
    //           //joystick control
    // }

    // priorState = currentState;
    // prior_centerCamera = centerCamera;
    // prior_leftCamera = leftCamera;
    // prior_rightCamera = rightCamera;

    /*    if ((!centerCamera && !leftCamera && !rightCamera) || (centerCamera && leftCamera && rightCamera)) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (stick.getTwist()), 0 );
      //joystick control
    }
    else if (!leftCamera && !rightCamera && centerCamera) {
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(),(stick.getTwist()), 0);
      //move forward
    }
    else if (leftCamera && centerCamera && !rightCamera){
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (Math.abs(stick.getTwist() * 1)), 0);
      //rotate counterclockwise and go straight
    }
    else if (rightCamera && centerCamera && !leftCamera){
      Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (Math.abs(stick.getTwist() * -1)), 0);
      //rotate clockwise and go straight 
    }
    else if (leftCamera && !centerCamera && !rightCamera){
      //rotate counterclockwise, move right and go forward
    }
    else if (rightCamera && !centerCamera && !rightCamera){
      //rotate clockwise, move left, and go straight
    }
    //The above if statement tells the robot what to do depending on which sensors are active

    Robot.drivetrainSubsystem.Drive(stick.getY(), stick.getX(), (.75*stick.getTwist()), 0);
    //Might not need the .75 
    */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //System.out.println("I am in isFinished");
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
}
