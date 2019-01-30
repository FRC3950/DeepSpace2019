/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

//public class CargoBallElevatorMotorUpCommand extends BallElevatorMotorUpCommand {
//  private double height = 3.16666666;
//  public CargoBallElevatorMotorUpCommand() {
//  }
//}

public abstract class BallElevatorMotorUpCommand extends Command  implements PIDOutput {


  public BallElevatorMotorUpCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    
   // System.out.println("Limit Switch Status=" + bottomLimitSwitch.get());
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

  @Override
  public void pidWrite(double output) {
    // set the output value to the elevator motor
  }
}
