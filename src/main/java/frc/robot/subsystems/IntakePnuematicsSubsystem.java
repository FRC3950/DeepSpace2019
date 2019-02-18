/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class IntakePnuematicsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Change values of these to be the correct ones
  final int intakeRotateLeftSolenoidChannel = 1;
  final int intakeRotateRightSolenoidChannel = 2;
  final int hatchOuttakeLeftSolenoidChannel = 3;
  final int hatchOuttakeRightSolenoidChannel = 4;
  final int ninjaStarSolenoidChannel = 5;

  public Solenoid intakeLeftRotateSolenoid = new Solenoid(1, intakeRotateLeftSolenoidChannel);
  public Solenoid intakeRightRotateSolenoid = new Solenoid(1, intakeRotateRightSolenoidChannel);
  public Solenoid hatchOuttakeLeftSolenoid = new Solenoid(1, hatchOuttakeLeftSolenoidChannel);
  public Solenoid hatchOuttakeRightSolenoid = new Solenoid(1, hatchOuttakeRightSolenoidChannel);
  public Solenoid ninjaStarSolenoid = new Solenoid(1, ninjaStarSolenoidChannel);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
   }

  public void toggleLift(){
    if (intakeLeftRotateSolenoid.get() == true && intakeRightRotateSolenoid.get() == true) {
      intakeLeftRotateSolenoid.set(false);
      intakeRightRotateSolenoid.set(false);
    } else {
      intakeLeftRotateSolenoid.set(true);
      intakeRightRotateSolenoid.set(true);
      //if the left solenoid is out and the right solenoid is out, then set it to the in postion, else, put them in the forward position
    }
  }
    public void toggleHatchOuttake(){
      if (hatchOuttakeLeftSolenoid.get() == true && hatchOuttakeRightSolenoid.get() == true) {
        hatchOuttakeLeftSolenoid.set(false);
        hatchOuttakeRightSolenoid.set(false);
      } else {
        hatchOuttakeLeftSolenoid.set(true);
        hatchOuttakeRightSolenoid.set(true);
      }
    }
      public void toggleNinjaStar(){
        if (ninjaStarSolenoid.get() == true) {
          ninjaStarSolenoid.set(false);
        } else {
          ninjaStarSolenoid.set(true);

        }
      }
        public boolean getNinjaStar() {
          return Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.get();
        }
}
