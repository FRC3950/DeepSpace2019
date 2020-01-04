/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class BallElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  final int ballElevatorShooterMotorChannel = 7;
  final int ballElevatorMotorChannel = 6;
  final int bottomLimitSwitchChannel = 0;
  final int rocketLimitSwitchChannel = 9;
  final int cargoLimitSwitchChannel = 2;
  final int isBallInLimitSwitchChannel = 1;
  

  public WPI_TalonSRX ballElevatorShooterMotor = new WPI_TalonSRX(ballElevatorShooterMotorChannel);
  public WPI_TalonSRX ballElevatorMotor = new WPI_TalonSRX(ballElevatorMotorChannel);
  private DigitalInput bottomLimitSwitch = new DigitalInput(bottomLimitSwitchChannel);
  private DigitalInput cargoLimitSwitch = new DigitalInput(cargoLimitSwitchChannel);
  private DigitalInput rocketLimitSwitch = new DigitalInput(rocketLimitSwitchChannel);
  public AnalogInput isBallIn = new AnalogInput(isBallInLimitSwitchChannel);

  

  double distancePerRotation;
//Center values, not sure what they should be for sure (could be top or bottom)

public WPI_TalonSRX getBallElevatorMotor() {
  return ballElevatorMotor;
  //gets the status of the elevator motor
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    ballElevatorMotor.setNeutralMode(NeutralMode.Brake);
    ballElevatorMotor.configPeakCurrentLimit(50);
  }

  public void BallElevatorMotorSet(double speed){
    ballElevatorMotor.set(speed);
    //sets elevator motor to value of leftstick on xboxcontroller
    //chick-fil-a
   }

  public void BallElevatorShooterMotorSet(double rightstick){
    ballElevatorMotor.set(rightstick);
  }

  public boolean bottomGetter() {
    return bottomLimitSwitch.get();
    //gets the status of the bottom limit switch
  }

  public boolean cargoGetter(){
    return cargoLimitSwitch.get();
    //gets the status of the cargo limit switch
  }

  public boolean rocketGetter(){
    return rocketLimitSwitch.get();
    //gets the status of the rocket limit switch
  }

  public boolean isBallIn(){
    if(Robot.ballElevatorSubsystem.isBallIn.getVoltage() >= 4) {
      return true;
    } else {
      return false;
    }
  }

  public double getEncoder(){
    double encoderCount = ballElevatorMotor.getSelectedSensorPosition(1);
    //System.out.println(encoderCount);
    return encoderCount;
    //gets the encoder value
  }
  
  public void resetEncoder() {
    getBallElevatorMotor().setSelectedSensorPosition(0, 0, 0);
  }

  public double getElevatorHeight() {
    return (getEncoder()/4096.0)*distancePerRotation;
    //not the actual value
  }
}
