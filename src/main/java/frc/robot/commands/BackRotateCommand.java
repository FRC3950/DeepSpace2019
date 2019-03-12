/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BackRotateCommand extends Command {

  double rotateTo = 0;
  boolean disabled = false;

  public BackRotateCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.gyroSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    disabled = false;
    System.out.println("BackRotateCommand.initialize");

    double robotAngle = Robot.gyroSubsystem.getCurrentAngle();
    System.out.println("BackRotateCommand.initialize robotAngle="  + robotAngle);
  
    if (robotAngle > -45 && robotAngle < 45) {
      rotateTo = 0;
   } else if (robotAngle > -180 && robotAngle < -45) {
    rotateTo = -90;
   } else if (robotAngle > 45 && robotAngle < 180) {
    rotateTo = 90;
   }
   System.out.println("BackRotateCommand.initialize rotateTo="  + rotateTo);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double robotAngle = Robot.gyroSubsystem.getCurrentAngle();
    if(Math.abs(robotAngle - rotateTo) > 1 && (robotAngle - rotateTo) < 0){
      Robot.drivetrainSubsystem.Drive(0, 0, 0.3, 0);
    System.out.println("BackRotateCommand.executeIF");
    } else if(Math.abs(robotAngle - rotateTo) > 1 && (robotAngle - rotateTo) > 0) {
      Robot.drivetrainSubsystem.Drive(0, 0, -0.3, 0);
    System.out.println("BackRotateCommand.executeELSEIF");
    } else {
      disabled = true;
    System.out.println("BackRotateCommand.executeELSE");
    }
    System.out.println("BackRotateCommand.execute"); 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("RotateCommand.isFinished="  + Robot.gyroSubsystem.getCurrentAngle());
    return disabled;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    disabled = false;
    System.out.println("BackRotateCommand.end");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    disabled = false;
    System.out.println("BackRotateCommand.interrupted");
  }
}
