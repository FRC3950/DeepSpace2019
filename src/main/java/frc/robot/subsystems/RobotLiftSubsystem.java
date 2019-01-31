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
  
  final int liftMotorChannel = 1;
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
  public void toggleBackPnuematicLift(){
    //  backLeftLiftSolenoid.set(!backLeftLiftSolenoid.get());
    //  backRightLiftSolenoid.set(!backRightLiftSolenoid.get());
      }
  
  public void toggleFrontPnuematicLift(){
    //  frontLeftLiftSolenoid.set(!backLeftLiftSolenoid.get());
    //  frontRightLiftSolenoid.set(!backRightLiftSolenoid.get());

  }
  public void liftMotorSet(double l){
    liftMotor.set(l);
  }

  public boolean dropBackPistons(){
    if(!isBackDown()){
      backLeftLiftSolenoid.set(!backLeftLiftSolenoid.get());
      backRightLiftSolenoid.set(!backRightLiftSolenoid.get());
    //open solenoid
    }
    return isFrontDown();
  }
  public boolean raiseBackPistons(){
    if(isBackDown()){
      backLeftLiftSolenoid.set(!backLeftLiftSolenoid.get());
      backRightLiftSolenoid.set(!backRightLiftSolenoid.get());
    }
    //close solenoid
    return true;
  }
  private boolean isBackDown(){
    if(backLeftLiftSolenoid.get()&& backRightLiftSolenoid.get()){
      return true;
    }
    return false;
    //ask solenoids their state
  }

  public boolean dropFrontPistons(){
    if(!isBackDown()){
      frontLeftLiftSolenoid.set(!frontLeftLiftSolenoid.get());
      frontRightLiftSolenoid.set(!frontRightLiftSolenoid.get());
    //open solenoid
    }
    return isFrontDown();
  }
  public boolean raiseFrontPistons(){
    if(isBackDown()){
      frontLeftLiftSolenoid.set(!frontLeftLiftSolenoid.get());
      frontRightLiftSolenoid.set(!frontRightLiftSolenoid.get());
    }
    //close solenoid
    return true;
  }
  private boolean isFrontDown(){
    if(frontLeftLiftSolenoid.get()&& frontRightLiftSolenoid.get()){
      return true;
    }
    return false;
    //ask solenoids their state
  }
}
