/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class BallElevatorCommand extends Command {

  boolean bottom = false;
  boolean top = false;
  XboxController controller = Robot.m_oi.xboxController;
  
  double getY = 0;
  double gndHeight = 0;

  public BallElevatorCommand() {
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
    getY = -controller.getY(Hand.kLeft);
    top = Robot.ballElevatorSubsystem.topGetter();
    gndHeight = Robot.ballElevatorSubsystem.getElevatorHeight();
    // height of elevator from ground 

    if(Robot.ballElevatorSubsystem.bottomGetter() && getY < 0) {
      Robot.ballElevatorSubsystem.resetEncoder();
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    } else if (Robot.ballElevatorSubsystem.topGetter() && getY > 0){
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    } else {
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(getY);
    }

    // // Has to do with controlling the elevator at certain heights
    // if(getY == 0 && gndHeight <= 5.4) {
    //   Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    // } else if (getY == 0) {
    //   Robot.ballElevatorSubsystem.BallElevatorMotorSet(0.1);
    //   }

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
