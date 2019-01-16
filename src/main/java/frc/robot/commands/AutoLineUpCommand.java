/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LimelightSubsystem;

public class AutoLineUpCommand extends Command {
  private PIDController controller;
  private boolean init = true;
  private static double minTx = -1.0;
  private static double maxTx = 1.0;
  private static double maxDistance = 15;
  //Must change the three values above when setting up actual robot
  private LimelightSubsystemTX limelightSubsystemTX = null;
  private LimelightSubsystem limelightSubsystem = null;

  public AutoLineUpCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limelightSubsystem);
  //  requires(Robot.drivetrainSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    limelightSubsystemTX = new LimelightSubsystemTX();
    controller = new PIDController(0, 0, 0, limelightSubsystemTX, new rotatePIDOut());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(init) {
      controller.enable();
      init = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double tx = limelightSubsystemTX.pidGet();
    double distance = limelightSubsystem.getDistance();
    if ((tx >= minTx || tx <= maxTx) && distance >= maxDistance){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    init = true;
    controller.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    init = true;
    controller.disable();
  }
}
