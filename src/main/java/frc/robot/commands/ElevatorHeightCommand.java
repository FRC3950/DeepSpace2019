/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorHeightCommand extends Command {

  public int stage;
  boolean finished = false;

  public ElevatorHeightCommand(int input) {
    // Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
    stage = input;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    finished = false;
  }

  // Called repeatedly when this Command is scheduled to run

  // 0 is bottom, 1 is middle, 2 is top
  @Override
  protected void execute() {

    //NOELLE DOESNT KNOW WHICH IS HIGHER ROCKET OR CARGO SOMEONE FIND OUT PLEASE
    //Rocket is 27.5 inch from ground to center of whole
    //Cargo is higher

    if(stage == 0) {
      if(Robot.ballElevatorSubsystem.bottomGetter() == true){
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
        finished = true;
        //System.out.println("ElevatorHeightCommand.execute.bottom.end");

      } else {
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(-0.35);
        //System.out.println("ElevatorHeightCommand.execute.bottom");
      }
      // } else if(Robot.ballElevatorSubsystem.cargoGetter()) {
      //   Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
      // } else if(Robot.ballElevatorSubsystem.rocketGetter()) {
      //   Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
    }
    if(stage == 1) {
      if(Robot.ballElevatorSubsystem.rocketGetter() == true){
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
        finished = true;
        //System.out.println("ElevatorHeightCommand.execute.rocket.end");
      } else {
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(-0.35);
        //System.out.println("ElevatorHeightCommand.execute.rocket");
      }
    }
    if(stage == 2) {
      if(Robot.ballElevatorSubsystem.cargoGetter()== true){
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(0);
        finished = true;
       // System.out.println("ElevatorHeightCommand.execute.cargo.end");

      } else{
        Robot.ballElevatorSubsystem.ballElevatorMotor.set(-0.35);
        //System.out.println("ElevatorHeightCommand.execute.cargo");
      }
    }

      Robot.ballElevatorSubsystem.resetEncoder();
    //Might need to add more, very unsure
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
