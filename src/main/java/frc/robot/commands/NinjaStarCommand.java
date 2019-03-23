/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NinjaStarCommand extends Command {

  boolean finished = false;

  public NinjaStarCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intakePnuematicsSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    finished = false;
    System.out.println("Ninja Star Command Initialize");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Ninja Star Command Execute");
    if(Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() == true && Robot.intakePnuematicsSubsystem.isHatchRightLinedUp() == true) {
       Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(false); //open
       System.out.println("Ninja Star Command Execute OPEN");
       finished = true;   
      }  else if(Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() == false || Robot.intakePnuematicsSubsystem.isHatchRightLinedUp() == false) {
        Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(true);
        System.out.println("Ninja Star Command Execute CLOSE");
        finished = true;
        }
    // else{
    //   Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(false);
    //   // System.out.println("Robot is NOT Lined Up" + "  HLS= " + Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() + "  HRS= " + Robot.intakePnuematicsSubsystem.isHatchRightLinedUp());
    //   //do not toggle Ninja Star
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("Ninja Star Command isFinished");
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    finished = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    finished = false;
  }
}
