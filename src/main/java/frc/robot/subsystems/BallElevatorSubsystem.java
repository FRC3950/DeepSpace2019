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
  
  final int ballElevatorMotorChannel = 2;
  final int ballElevatorSolenoidChannel = 5;
  final int bottomLimitSwitchChannel = 2;
  final int topLimitSwitchChannel = 3;

  private Solenoid ballElevatorSolenoid = new Solenoid(ballElevatorSolenoidChannel);
  private WPI_TalonSRX ballElevatorMotor = new WPI_TalonSRX(ballElevatorMotorChannel);
  private DigitalInput bottomLimitSwitch = new DigitalInput(bottomLimitSwitchChannel);
  private DigitalInput topLimitSwitch = new DigitalInput(topLimitSwitchChannel);
  
  private CargoDoorSubsystem cargoDoorSubsystem = new CargoDoorSubsystem();
  private CargoShooterSubsystem cargoShooterSubsystem = new CargoShooterSubsystem();

  double cargoHeight = 38;
  double firstRocketHeight = 27.5;
  double secondRocketHeight = 55.5;
  double distancePerRotation;
//Center values, not sure what they should be for sure (could be top or bottom)

public double getCargoHeight(){
  return cargoHeight;
}
public double getFirstRocketHeight(){
  return firstRocketHeight;
}
public double getSecondRocketHeight(){
  return secondRocketHeight;
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void BallElevatorMotorSet(double leftstick){
    ballElevatorMotor.set(leftstick);
  }
  public boolean bottomGetter() {
    return bottomLimitSwitch.get();
  }
  public boolean topGetter(){
    return topLimitSwitch.get();
  }
  public int getEncoder(){
    return ballElevatorMotor.getSelectedSensorPosition(0);
  }
  
  public void resetEncoder() {
    ballElevatorMotor.setSelectedSensorPosition(0, 0, 0);
  }
  public double getElevatorHeight() {
    return (getEncoder()/4096.0)*distancePerRotation;
  }
}
