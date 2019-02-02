/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Date;

import edu.wpi.first.wpilibj.command.Command;

public class DelayCommand extends Command {
  boolean isFirst = true;
  long delay;
  long endTime;
  public DelayCommand(long delay) { // delay in ms
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.delay = delay;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(isFirst) {
       endTime = System.currentTimeMillis() + delay;
      isFirst = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() >= endTime;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    isFirst = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    isFirst = true;
  }
}
