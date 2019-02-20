/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallElevatorIntakeCommand extends Command {
  boolean finished = false;
  public BallElevatorIntakeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
    requires(Robot.intakeMotorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.ballElevatorSubsystem.isBallIn() == false) {
      Robot.ballElevatorSubsystem.ballElevatorShooterMotor.set(0);
      Robot.intakeMotorSubsystem.intakeMotor.set(0);
      finished = true;
    } else {
      Robot.ballElevatorSubsystem.ballElevatorShooterMotor.set(-.7);
      Robot.intakeMotorSubsystem.intakeMotor.set(.7);
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
    finished = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    finished = false;
  }
}
