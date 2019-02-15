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
  double lastOut = 1;
  boolean start = true;
  public StraightenRobotPIDCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    source = new PIDSourceLineFollower();
    pid = new PIDController(P, I, D, F, source, this);
  
    pid.setInputRange(-30, 30);
    pid.setOutputRange(-1, 1);
    pid.setPercentTolerance(5.0);
    pid.setContinuous(false);
    pid.setSetpoint(0);
    pid.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(start == true){
      pid.enable();
      start = false;
    } 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return pid.onTarget();
    //return Math.abs(Robot.ultrasonicSubsystem.getRobotAngle()) < 1 && Math.abs(lastOut) < 0.05;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrainSubsystem.Drive(0, 0, 0, 0);
     pid.disable();
     start = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrainSubsystem.Drive(0, 0, 0, 0);
    pid.disable();
    start = true;
  }

  @Override
  public void pidWrite(double output) {
    lastOut = output;
    Robot.drivetrainSubsystem.Drive(0, 0, output, 0);
  }
}
