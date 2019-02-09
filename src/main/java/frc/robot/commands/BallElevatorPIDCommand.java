/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Logger;
import frc.robot.PIDSourceElevator;
import frc.robot.Robot;
import frc.robot.Logger.LogLevel;

public class BallElevatorPIDCommand extends Command implements PIDOutput{

  double P = SmartDashboard.getNumber("P (elevator)",0.0);
  double I = SmartDashboard.getNumber("I (elevator)",0.0); 
  double D = SmartDashboard.getNumber("D (elevator)",0.0);
  double F = SmartDashboard.getNumber("F (elevator)",0.0);

  PIDController pid;
  double setpoint = 0;
  PIDSourceElevator source;
  int range = 10;


  public BallElevatorPIDCommand(double input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
    pid = null; //new PIDController(P, I, D, F, source, this);
    source = null; //new PIDSourceElevator();
    setpoint = input;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.ballElevatorSubsystem.resetEncoder();
    source.setPIDSourceType(PIDSourceType.kDisplacement);
    pid.setInputRange(0, setpoint);
    pid.setOutputRange(-.2, .2);
    pid.setPercentTolerance(5.0);
    pid.setContinuous(false);
    pid.setPID(P, I, D, F);
    pid.setSetpoint(setpoint);
    pid.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    int velocity = Robot.ballElevatorSubsystem.ballElevatorMotor.getSelectedSensorVelocity(0);
    System.out.println("velocity is " + velocity);
    System.out.println("pid on target is" + pid.onTarget());
    return(pid.onTarget() && (velocity >= range) && (velocity <= range)) || (Robot.ballElevatorSubsystem.bottomGetter()) ||(Robot.ballElevatorSubsystem.topGetter());

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  //  Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    pid.disable();
    System.out.println("done intr");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  @Override
  public void pidWrite(double output) {
    // set motor voltage for elevatotr subsystem
    Robot.ballElevatorSubsystem.BallElevatorMotorSet(output);
    if(Robot.ballElevatorSubsystem.topGetter())
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    Logger.log(LogLevel.info, "Encoder Height" + Robot.ballElevatorSubsystem.getElevatorHeight());
    Logger.log(Logger.LogLevel.info, "elevator enc counts" + Robot.ballElevatorSubsystem.ballElevatorMotor.getSelectedSensorPosition(0));  

  }
}
