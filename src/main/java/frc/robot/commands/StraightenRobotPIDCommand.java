/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PIDSourceLineFollower;
import frc.robot.Robot;

public class StraightenRobotPIDCommand extends Command implements PIDOutput {
  double P = SmartDashboard.getNumber("P (lineFollower)",0.0);
  double I = SmartDashboard.getNumber("I (lineFollower)",0.0); 
  double D = SmartDashboard.getNumber("D (lineFollower)",0.0);
  double F = SmartDashboard.getNumber("F (lineFollower)",0.0);

  PIDController pid;
  PIDSource source;
  double setpoint = 0;
  public StraightenRobotPIDCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    source = new PIDSourceLineFollower();
    pid = new PIDController(P, I, D, F, source, this);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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
  //    Robot.drivetrainSubsystem.Drive(0, 0, 0, output);
  }
}
