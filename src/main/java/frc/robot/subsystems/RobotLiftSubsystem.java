/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RobotLiftMotorCommand;

/**
 * Add your docs here.
 */
public class RobotLiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  final int liftMotorChannel = 8;
  final int backLeftLiftSolenoidChannel1 = 1;
  final int backLeftLiftSolenoidChannel2 = 6;
  final int backRightLiftSolenoidChannel1 = 0;
  final int backRightLiftSolenoidChannel2 = 7;
  final int frontLeftLiftSolenoidChannel1 = 2;
  final int frontLeftLiftSolenoidChannel2 = 5;
  final int frontRightLiftSolenoidChannel1 = 3;
  final int frontRightLiftSolenoidChannel2 = 4;
  
  
  public WPI_TalonSRX liftMotor = new WPI_TalonSRX(liftMotorChannel);
  public DoubleSolenoid backLeftLiftSolenoid = new DoubleSolenoid(2,backLeftLiftSolenoidChannel1,backLeftLiftSolenoidChannel2);
  public DoubleSolenoid backRightLiftSolenoid = new DoubleSolenoid(2,backRightLiftSolenoidChannel1,backRightLiftSolenoidChannel2);
  public DoubleSolenoid frontLeftLiftSolenoid = new DoubleSolenoid(2,frontLeftLiftSolenoidChannel1,frontLeftLiftSolenoidChannel2);
  public DoubleSolenoid frontRightLiftSolenoid = new DoubleSolenoid(2,frontRightLiftSolenoidChannel1,frontRightLiftSolenoidChannel2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new RobotLiftMotorCommand());
  }
  // public void liftMotorSet(double xSpeed){
  //   double y;
  //   y = -xSpeed;
  //   if(y<0.2 && y>-0.2) y = 0;
  //   liftMotor.set(y);
  // }

  public void dropPistons(){
      if((backLeftLiftSolenoid.get() == DoubleSolenoid.Value.kForward) && (backRightLiftSolenoid.get() == DoubleSolenoid.Value.kForward)
        && (frontLeftLiftSolenoid.get() == DoubleSolenoid.Value.kReverse) && (frontRightLiftSolenoid.get() == DoubleSolenoid.Value.kReverse)) {
      backLeftLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
      backRightLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
      frontLeftLiftSolenoid.set(DoubleSolenoid.Value.kForward);
      frontRightLiftSolenoid.set(DoubleSolenoid.Value.kForward);
      } else {
        backLeftLiftSolenoid.set(DoubleSolenoid.Value.kForward);
        backRightLiftSolenoid.set(DoubleSolenoid.Value.kForward);
        frontLeftLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
        frontRightLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
      }
  }
  public void toggleBackPistons(){
    if((backLeftLiftSolenoid.get() == DoubleSolenoid.Value.kReverse) || (backRightLiftSolenoid.get() == DoubleSolenoid.Value.kReverse)) {
  backLeftLiftSolenoid.set(DoubleSolenoid.Value.kForward);
  backRightLiftSolenoid.set(DoubleSolenoid.Value.kForward);
  } else {
    backLeftLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    backRightLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  }
  public void toggleFrontPistons(){
    if((frontLeftLiftSolenoid.get() == DoubleSolenoid.Value.kReverse) || (frontRightLiftSolenoid.get() == DoubleSolenoid.Value.kReverse)) {
  frontLeftLiftSolenoid.set(DoubleSolenoid.Value.kForward);
  frontRightLiftSolenoid.set(DoubleSolenoid.Value.kForward);
  } else {
    frontLeftLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    frontRightLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  }
}
