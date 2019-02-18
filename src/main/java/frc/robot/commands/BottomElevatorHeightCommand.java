/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.print.DocFlavor.STRING;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BottomElevatorHeightCommand extends Command {

  public int stage;

  public BottomElevatorHeightCommand(int input) {
    // Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
    stage = input;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run

  // 0 is bottom, 1 is middle, 2 is top
  @Override
  protected void execute() {

    //NOELLE DOESNT KNOW WHICH IS HIGHER ROCKET OR CARGO SOMEONE FIND OUT PLEASE

    if(stage == 0) {
      Robot.ballElevatorSubsystem.ballElevatorMotor.set(1);
      if(Robot.ballElevatorSubsystem.bottomGetter()){
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
      } else if(Robot.ballElevatorSubsystem.rocketGetter()) {
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
      } else if(Robot.ballElevatorSubsystem.rocketGetter()) {
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
      }
    }

      Robot.ballElevatorSubsystem.resetEncoder();
    //Might need to add more, very unsure
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return true;
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
