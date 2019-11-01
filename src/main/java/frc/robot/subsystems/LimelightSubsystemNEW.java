/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class LimelightSubsystemNEW extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }
      NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
      NetworkTableEntry tx = table.getEntry("tx");
      //horizontal offset from crosshair to target
      NetworkTableEntry ty = table.getEntry("ty");
      //vertical offset from crosshair to target
      NetworkTableEntry ta = table.getEntry("ta");
      //target area
      NetworkTableEntry tv = table.getEntry("tv");
      //whether the limelight has any valid target (0 or 1)

}
