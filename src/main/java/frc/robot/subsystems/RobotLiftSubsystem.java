/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class RobotLiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  final int liftMotorChannel = 4;
  final int backLeftLiftSolenoidChannel = 0;
  final int backRightLiftSolenoidChannel = 1;
  final int frontLeftLiftSolenoidChannel = 2;
  final int frontRightLiftSolenoidChannel = 3;
  
  
  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(liftMotorChannel);
  private Solenoid backLeftLiftSolenoid = new Solenoid(backLeftLiftSolenoidChannel);
  private Solenoid backRightLiftSolenoid = new Solenoid (backRightLiftSolenoidChannel);
  private Solenoid frontLeftLiftSolenoid = new Solenoid (frontLeftLiftSolenoidChannel);
  private Solenoid frontRightLiftSolenoid = new Solenoid (frontRightLiftSolenoidChannel);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }
  public void liftMotorSet(double ySpeed){
    liftMotor.set(ySpeed);
  }

  public boolean dropBackPistons(){
    if(!isBackDown()){
      backLeftLiftSolenoid.set(true);
      backRightLiftSolenoid.set(true);
    //open solenoid
    }
    return isFrontDown();
  }
  public boolean raiseBackPistons(){
    if(isBackDown()){
      backLeftLiftSolenoid.set(false);
      backRightLiftSolenoid.set(false);
    }
    //close solenoid
    return isBackDown();
  }
  private boolean isBackDown(){
    return backLeftLiftSolenoid.get()&& backRightLiftSolenoid.get();
    //ask solenoids their state
  }

  public boolean dropFrontPistons(){
    if(!isBackDown()){
      frontLeftLiftSolenoid.set(true);
      frontRightLiftSolenoid.set(true);
    //open solenoid
    }
    return isFrontDown();
  }
  public boolean raiseFrontPistons(){
    if(isBackDown()){
      frontLeftLiftSolenoid.set(false);
      frontRightLiftSolenoid.set(false);
    }
    //close solenoid
    return isBackDown();
  }
  private boolean isFrontDown(){
    return frontLeftLiftSolenoid.get()&& frontRightLiftSolenoid.get();
    //ask solenoids their state
  }
  public boolean toggleBackPistons(){
    backLeftLiftSolenoid.set(!backLeftLiftSolenoid.get());
    backRightLiftSolenoid.set(!backRightLiftSolenoid.get());
    //open solenoid
    return isBackDown();
  }
  public boolean toggleFrontPistons(){
    frontLeftLiftSolenoid.set(!frontLeftLiftSolenoid.get());
    frontRightLiftSolenoid.set(!frontRightLiftSolenoid.get());
    //open solenoid
    return isFrontDown();
    }
}
