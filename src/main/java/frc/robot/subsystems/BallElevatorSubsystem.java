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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BallElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public WPI_TalonSRX ballElevatorMotor = RobotMap.ballElevatorMotor;
  public Solenoid ballElevatorSolenoid = RobotMap.ballElevatorSolenoid;
  public DigitalInput bottomLimitSwitch = RobotMap.bottomLimitSwitch;
  public DigitalInput topLimitSwitch = RobotMap.topLimitSwitch;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void toggleBallElevatorSolenoid(){
    ballElevatorSolenoid.set(!ballElevatorSolenoid.get());

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
}
