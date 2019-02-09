/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class IntakePnuematicsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Change values of these to be the correct ones
  final int intakeRotateLeftSolenoidChannel1 = 0;
  final int intakeRotateLeftSolenoidChannel2 = 2;
  final int intakeRotateRightSolenoidChannel1 = 5;
  final int intakeRotateRightSolenoidChannel2 = 7;
  final int hatchOuttakeLeftSolenoidChannel1 = 2;
  final int hatchOuttakeLeftSolenoidChannel2 = 0;
  final int hatchOuttakeRightSolenoidChannel1 = 3;
  final int hatchOuttakeRightSolenoidChannel2 = 0;
  final int ninjaStarSolenoidChannel1 = 0;
  final int ninjaStarSolenoidChannel2 = 1;

  public DoubleSolenoid intakeLeftRotateSolenoid = null; //new DoubleSolenoid(intakeRotateLeftSolenoidChannel1, intakeRotateLeftSolenoidChannel2);
  public DoubleSolenoid intakeRightRotateSolenoid = null; //new DoubleSolenoid(intakeRotateRightSolenoidChannel1, intakeRotateRightSolenoidChannel2);
  private DoubleSolenoid hatchOuttakeLeftSolenoid = null; //new DoubleSolenoid(hatchOuttakeLeftSolenoidChannel1, hatchOuttakeLeftSolenoidChannel2);
  private DoubleSolenoid hatchOuttakeRightSolenoid = null; //new DoubleSolenoid(hatchOuttakeRightSolenoidChannel1, hatchOuttakeRightSolenoidChannel2);
  private DoubleSolenoid ninjaStarSolenoid = null; //new DoubleSolenoid(ninjaStarSolenoidChannel1, ninjaStarSolenoidChannel2);


  // private DoubleSolenoid liftSolenoid1 = RobotMap.liftIntakeSolenoid1;
  // private DoubleSolenoid liftSolenoid2 = RobotMap.liftIntakeSolenoid2;
  // private DoubleSolenoid hatchOuttake1 = RobotMap.hatchOuttakeSolenoid1;
  // private DoubleSolenoid hatchOuttake2 = RobotMap.hatchOuttakeSolenoid2;
  // private DoubleSolenoid ninjaStar = RobotMap.ninjaStarSolenoid;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
   }

  public void toggleLift(){
    if (intakeLeftRotateSolenoid.get() == DoubleSolenoid.Value.kForward && 
        intakeRightRotateSolenoid.get() == DoubleSolenoid.Value.kForward) {
      intakeLeftRotateSolenoid.set(DoubleSolenoid.Value.kReverse);
      intakeRightRotateSolenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      intakeLeftRotateSolenoid.set(DoubleSolenoid.Value.kForward);
      intakeRightRotateSolenoid.set(DoubleSolenoid.Value.kForward);
      //if the left solenoid is out and the right solenoid is out, then set it to the in postion, else, put them in the forward position
    }
  }
    public void toggleHatchOuttake(){
      if (hatchOuttakeLeftSolenoid.get() == DoubleSolenoid.Value.kForward && 
        hatchOuttakeRightSolenoid.get() == DoubleSolenoid.Value.kForward) {
        hatchOuttakeLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
        hatchOuttakeRightSolenoid.set(DoubleSolenoid.Value.kReverse);
      } else {
        hatchOuttakeLeftSolenoid.set(DoubleSolenoid.Value.kForward);
        hatchOuttakeRightSolenoid.set(DoubleSolenoid.Value.kForward);
      }
    }
      public void toggleNinjaStar(){
        if (ninjaStarSolenoid.get() == DoubleSolenoid.Value.kForward) {
          ninjaStarSolenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
          ninjaStarSolenoid.set(DoubleSolenoid.Value.kForward);

        }
  }
}
