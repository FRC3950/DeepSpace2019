/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallShooterSubsystemV2 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //  public DoubleSolenoid shooterSolenoid = new DoubleSolenoid(1, 0, 7);

  // NOT USING BECAUSE NOT USING PISTON ANYMORE

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }



  // public boolean closeCargoDoor(){
  //   if(isOpen()){
  //     shooterSolenoid.set(false);
  //   }
  //   //closes solenoid
  //   return isOpen();
  // }
  // private boolean isOpen(){
  //   return shooterSolenoid.get();
  //   //ask solenoids their state
  // }
  // public void closeShooter(){
  //   shooterSolenoid.set(Value.kReverse);
  // }
  // public void openShooter(){
  //   shooterSolenoid.set(Value.kForward);
  // }
}
