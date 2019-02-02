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

  //Change values of these to be the correct ones
  // final int intakeRotateLeftSolenoidChannel1 = 0;
  // final int intakeRotateLeftSolenoidChannel2 = 0;
  // final int intakeRotateRightSolenoidChannel1 = 1;
  // final int intakeRotateRightSolenoidChannel2 = 0;
  // final int hatchOuttakeLeftSolenoidChannel1 = 2;
  // final int hatchOuttakeLeftSolenoidChannel2 = 0;
  // final int hatchOuttakeRightSolenoidChannel1 = 3;
  // final int hatchOuttakeRightSolenoidChannel2 = 0;
  // final int ninjaStarSolenoidChannel1 = 4;
  // final int ninjaStarSolenoidChannel2 = 0;

  // private DoubleSolenoid intakeLeftRotateSolenoid = new DoubleSolenoid(intakeRotateLeftSolenoidChannel1, intakeRotateLeftSolenoidChannel2);
  // private DoubleSolenoid intakeRightRotateSolenoid = new DoubleSolenoid(intakeRotateRightSolenoidChannel1, intakeRotateRightSolenoidChannel2);
  // private DoubleSolenoid hatchOuttakeLeftSolenoid = new DoubleSolenoid(hatchOuttakeLeftSolenoidChannel1, hatchOuttakeLeftSolenoidChannel2);
  // private DoubleSolenoid hatchOuttakeRightSolenoid = new DoubleSolenoid(hatchOuttakeRightSolenoidChannel1, hatchOuttakeRightSolenoidChannel2);
  // private DoubleSolenoid ninjaStarSolenoid = new DoubleSolenoid(ninjaStarSolenoidChannel1, ninjaStarSolenoidChannel2);


  // // private DoubleSolenoid liftSolenoid1 = RobotMap.liftIntakeSolenoid1;
  // // private DoubleSolenoid liftSolenoid2 = RobotMap.liftIntakeSolenoid2;
  // // private DoubleSolenoid hatchOuttake1 = RobotMap.hatchOuttakeSolenoid1;
  // // private DoubleSolenoid hatchOuttake2 = RobotMap.hatchOuttakeSolenoid2;
  // // private DoubleSolenoid ninjaStar = RobotMap.ninjaStarSolenoid;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  // }
  // public void toggleLift(){
  //   if (intakeLeftRotateSolenoid.get() == DoubleSolenoid.Value.kReverse && 
  //       intakeRightRotateSolenoid.get() == DoubleSolenoid.Value.kReverse) {
  //     intakeLeftRotateSolenoid.set(DoubleSolenoid.Value.kForward);
  //     intakeRightRotateSolenoid.set(DoubleSolenoid.Value.kForward);
  //   } else {
  //     intakeLeftRotateSolenoid.set(DoubleSolenoid.Value.kReverse);
  //     intakeRightRotateSolenoid.set(DoubleSolenoid.Value.kReverse);
  //   }
  // }
  //   public void toggleHatchOuttake(){
  //     if (hatchOuttakeLeftSolenoid.get() == DoubleSolenoid.Value.kReverse && 
  //       hatchOuttakeRightSolenoid.get() == DoubleSolenoid.Value.kReverse) {
  //       hatchOuttakeLeftSolenoid.set(DoubleSolenoid.Value.kForward);
  //       hatchOuttakeRightSolenoid.set(DoubleSolenoid.Value.kForward);
  //     } else {
  //       hatchOuttakeLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
  //       hatchOuttakeRightSolenoid.set(DoubleSolenoid.Value.kReverse);
  //     }
  //   }
  //     public void toggleNinjaStar(){
  //       if (ninjaStarSolenoid.get() == DoubleSolenoid.Value.kReverse) {
  //         ninjaStarSolenoid.set(DoubleSolenoid.Value.kForward);
  //       } else {
  //         ninjaStarSolenoid.set(DoubleSolenoid.Value.kReverse);

  //       }
  }
}
