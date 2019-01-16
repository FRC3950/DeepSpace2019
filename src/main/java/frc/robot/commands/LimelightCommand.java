/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimelightCommand extends Command {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = null;
  NetworkTableEntry ty = null;
  NetworkTableEntry ta = null;
  NetworkTableEntry tv = null;
  NetworkTableEntry ts = null;
  NetworkTableEntry tl = null;
  NetworkTableEntry tshort = null;
  NetworkTableEntry tlong = null;
  NetworkTableEntry thoriz = null;
  NetworkTableEntry tvert = null;
  

    

  public LimelightCommand() {
    System.out.println("Hello World constructor");
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

   
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Hello World initialize");

    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
    ts = table.getEntry("ts");
    tl = table.getEntry("tl");
    tshort = table.getEntry("tshort");
    tlong = table.getEntry("tlong");
    thoriz = table.getEntry("thoriz");
    tvert = table.getEntry("tvert");


  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    System.out.println("Hello World execute");
    for (String key : table.getKeys()) {
      System.out.println(key);
    }
    //Robot.limelightSubsystem.limelightRead();

    System.out.println("tx ="+ tx.getDouble(0.0));
    System.out.println("ty ="+ ty.getDouble(0.0));
    System.out.println("ta ="+ ta.getDouble(0.0));
    System.out.println("tv ="+ tv.getDouble(0.0));
    System.out.println("ts ="+ ts.getDouble(0.0));
    System.out.println("tl ="+ tl.getDouble(0.0));
    System.out.println("tshort ="+ tshort.getDouble(0.0));
    System.out.println("tlong ="+ tlong.getDouble(0.0));
    System.out.println("thoriz ="+ thoriz.getDouble(0.0));
    System.out.println("tvert ="+ tvert.getDouble(0.0));

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("Hello World isfinished");
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
