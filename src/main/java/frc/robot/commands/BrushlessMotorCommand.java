/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BrushlessMotorCommand extends Command {
  public BrushlessMotorCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrainSubsystem);
  }
    // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("initialized");
    Robot.drivetrainSubsystem.frontRight.set(1.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("fr= " + Robot.drivetrainSubsystem.frontRight.getEncoder().getVelocity());
    System.out.println("fr= " + Robot.drivetrainSubsystem.frontRight.getEncoder().getPosition());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished");
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("end");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("interrupted");
  }
}
