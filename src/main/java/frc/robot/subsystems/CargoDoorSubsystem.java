/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoDoorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  final int leftDoorSolenoidChannel = 6;
  final int rightDoorSolenoidChannel = 7;

  private Solenoid leftDoorSolenoid = new Solenoid(leftDoorSolenoidChannel);
  private Solenoid rightDoorSolenoid = new Solenoid(rightDoorSolenoidChannel);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public boolean openCargoDoor(){
    if(!isOpen()){
      leftDoorSolenoid.set(!leftDoorSolenoid.get());
      rightDoorSolenoid.set(!rightDoorSolenoid.get());
    //open solenoid
    }
    return isOpen();
  }
  public boolean closeCargoDoor(){
    if(isOpen()){
      leftDoorSolenoid.set(!leftDoorSolenoid.get());
      rightDoorSolenoid.set(!rightDoorSolenoid.get());
    }
    //close solenoid
    return true;
  }
  private boolean isOpen(){
    if(leftDoorSolenoid.get()&& rightDoorSolenoid.get()){
      return true;
    }
    return false;
    //ask solenoids their state
  }
}
