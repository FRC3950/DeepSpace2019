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
  // private WPI_TalonSRX liftMotor = RobotMap.liftMotor;
  // private Solenoid backLeftLiftSolenoid = RobotMap.backLeftLiftSolenoid;
  // private Solenoid backRightLiftSolenoid = RobotMap.backRightLiftSolenoid;
  // private Solenoid frontLeftLiftSolenoid = RobotMap.frontLeftLiftSolenoid;
  // private Solenoid frontRightLiftSolenoid = RobotMap.frontLeftLiftSolenoid;

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
    // liftMotor.set(l);
  }
}
