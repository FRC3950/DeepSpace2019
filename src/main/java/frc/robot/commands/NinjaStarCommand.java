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
  public NinjaStarCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intakePnuematicsSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() == true && Robot.intakePnuematicsSubsystem.isHatchRightLinedUp() == true) {
       Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(true); //open   
       // System.out.println("Robot is Lined Up" + "  HLS= " + Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() + "  HRS= " + Robot.intakePnuematicsSubsystem.isHatchRightLinedUp());
    }
    // else{
    //   Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(false);
    //   // System.out.println("Robot is NOT Lined Up" + "  HLS= " + Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() + "  HRS= " + Robot.intakePnuematicsSubsystem.isHatchRightLinedUp());
    //   //do not toggle Ninja Star
    // }

    if(Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() == false || Robot.intakePnuematicsSubsystem.isHatchRightLinedUp() == false) {
      Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(false);
      // System.out.println("Robot is NOT Lined Up" + "  HLS= " + Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp() + "  HRS= " + Robot.intakePnuematicsSubsystem.isHatchRightLinedUp());

    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
