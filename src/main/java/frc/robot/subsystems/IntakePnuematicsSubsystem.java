/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakePnuematicsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DoubleSolenoid liftSolenoid1 = RobotMap.liftIntakeSolenoid1;
  private DoubleSolenoid liftSolenoid2 = RobotMap.liftIntakeSolenoid2;
  private DoubleSolenoid hatchOuttake1 = RobotMap.hatchOuttakeSolenoid1;
  private DoubleSolenoid hatchOuttake2 = RobotMap.hatchOuttakeSolenoid2;
  private DoubleSolenoid ninjaStar = RobotMap.ninjaStarSolenoid;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void toggleLift(){
    if (liftSolenoid1.get() == DoubleSolenoid.Value.kReverse && 
        liftSolenoid2.get() == DoubleSolenoid.Value.kReverse) {
      liftSolenoid1.set(DoubleSolenoid.Value.kForward);
      liftSolenoid2.set(DoubleSolenoid.Value.kForward);
    } else {
      liftSolenoid1.set(DoubleSolenoid.Value.kReverse);
      liftSolenoid2.set(DoubleSolenoid.Value.kReverse);
    }
  }
    public void toggleHatchOuttake(){
      if (hatchOuttake1.get() == DoubleSolenoid.Value.kReverse && 
        hatchOuttake2.get() == DoubleSolenoid.Value.kReverse) {
        hatchOuttake1.set(DoubleSolenoid.Value.kForward);
        hatchOuttake2.set(DoubleSolenoid.Value.kForward);
      } else {
        hatchOuttake1.set(DoubleSolenoid.Value.kReverse);
        hatchOuttake2.set(DoubleSolenoid.Value.kReverse);
      }
    }
      public void toggleNinjaStar(){
        if (ninjaStar.get() == DoubleSolenoid.Value.kReverse) {
          ninjaStar.set(DoubleSolenoid.Value.kForward);
        } else {
          ninjaStar.set(DoubleSolenoid.Value.kReverse);

    }
  }

}
