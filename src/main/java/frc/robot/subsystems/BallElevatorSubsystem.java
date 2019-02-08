/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  final int ballElevatorMotorChannel = 6;
  final int ballElevatorSolenoidChannel = 5;
  final int bottomLimitSwitchChannel = 2;
  final int topLimitSwitchChannel = 3;

  private Solenoid ballElevatorSolenoid = new Solenoid(ballElevatorSolenoidChannel);
  public WPI_TalonSRX ballElevatorMotor = new WPI_TalonSRX(ballElevatorMotorChannel);
  private DigitalInput bottomLimitSwitch = new DigitalInput(bottomLimitSwitchChannel);
  private DigitalInput topLimitSwitch = new DigitalInput(topLimitSwitchChannel);
  

  double cargoHeight = 38;
  double firstRocketHeight = 27.5;
  double secondRocketHeight = 55.5;
  double groundHeight = 6;
  double distancePerRotation;
//Center values, not sure what they should be for sure (could be top or bottom)

public double getCargoHeight(){
  return cargoHeight;
  //get height of cargoship
}
public double getFirstRocketHeight(){
  return firstRocketHeight;
  //gets height of first stage rocket
}
public double getSecondRocketHeight(){
  return secondRocketHeight;
  //gets height of second stage rocket
}
public double getGroundHeight(){
  return groundHeight;
  //gets height of bottom position of elevator
}
/**
 * @return the ballElevatorMotor
 */
public WPI_TalonSRX getBallElevatorMotor() {
  return ballElevatorMotor;
  //gets the status of the elevator motor
}
/**
 * @param ballElevatorMotor the ballElevatorMotor to set
 */
public void setBallElevatorMotor(WPI_TalonSRX ballElevatorMotor) {	
  this.ballElevatorMotor = ballElevatorMotor;
  //sets ball elevator motor for PID
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void BallElevatorMotorSet(double leftstick){
    ballElevatorMotor.set(leftstick);
    //sets elevator motor to value of leftstick on xboxcontroller
    //chick-fil-a
   }
  public boolean bottomGetter() {
    return bottomLimitSwitch.get();
    //gets the status of the bottom limit switch
  }
  public boolean topGetter(){
    return topLimitSwitch.get();
    //gets the status of the top limit switch
  }
  public int getEncoder(){
    return getBallElevatorMotor().getSelectedSensorPosition(0);
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
