/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallElevatorShooterMotorCommand extends Command {

  double speed = 0;
  Timer timer = new Timer();
  boolean finished = false;

  public BallElevatorShooterMotorCommand(double input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);

    speed = input;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(timer.get() <= 3) {
      Robot.ballElevatorSubsystem.BallElevatorShooterMotorSet(speed);
      System.out.println("I am in ball shooter auto execute");
      finished = false;
    } else {
      timer.stop();
      Robot.ballElevatorSubsystem.BallElevatorShooterMotorSet(0);
      finished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
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
