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
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PIDSourceElevator;
import frc.robot.Robot;

public class BallElevatorPIDCommand extends Command implements PIDOutput{

  double P = SmartDashboard.getNumber("P (elevator)",0.0);
  double I = SmartDashboard.getNumber("I (elevator)",0.0); 
  double D = SmartDashboard.getNumber("D (elevator)",0.0);
  double F = SmartDashboard.getNumber("F (elevator)",0.5);

  PIDController pid;
  double setpoint = 0;
  PIDSource source;
  int range = 10;
  boolean start = true;

  public BallElevatorPIDCommand(double input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballElevatorSubsystem);
  
    setpoint = input;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    source = new PIDSourceElevator();
    pid = new PIDController(P, I, D, F, source, this);
  
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
    if(start == true){
      pid.enable();
      start = false;
    } 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    int velocity = Robot.ballElevatorSubsystem.ballElevatorMotor.getSelectedSensorVelocity(0);
    // System.out.println("velocity is " + velocity);
    // System.out.println("pid on target is" + pid.onTarget());
    return(pid.onTarget() && (velocity >= range) && (velocity <= range)) || (Robot.ballElevatorSubsystem.bottomGetter());

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  //  Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
  pid.disable();
  start = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    pid.disable();
    start = true;
  }

  @Override
  public void pidWrite(double output) {
    // set motor voltage for elevatotr subsystem
    if(Robot.ballElevatorSubsystem.rocketGetter() && output > 0)
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
    if(Robot.ballElevatorSubsystem.bottomGetter() && output < 0)
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(0);
      Robot.ballElevatorSubsystem.BallElevatorMotorSet(output);
    // Logger.log(LogLevel.info, "Encoder Height" + Robot.ballElevatorSubsystem.getElevatorHeight());
    // Logger.log(Logger.LogLevel.info, "elevator enc counts" + Robot.ballElevatorSubsystem.ballElevatorMotor.getSelectedSensorPosition(0));  

  }
}
