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
public class LimelightSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public double getDistance(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tshort = table.getEntry("tshort");
    double shortLength = tshort.getDouble(0.0);
    if (Double.compare(shortLength, 0.0) == 0) {
      return 0.0;
    }
    return 0.03125*shortLength*shortLength - 3.866 *shortLength + 148.8;
    //Need to redo equation on Logger Pro once we know where it is mounted on the robot 
  }

  public void limelightRead() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    //horizontal offset from crosshair to target
    NetworkTableEntry ty = table.getEntry("ty");
    //vertical offset from crosshair to target
    NetworkTableEntry ta = table.getEntry("ta");
    //target area
    NetworkTableEntry tv = table.getEntry("tv");
    //whether the limelight has any valid target (0 or 1)
    NetworkTableEntry ts = table.getEntry("ts");
    //skew or rotation
    NetworkTableEntry tl = table.getEntry("tl");
    //pipelines latency contribution
    NetworkTableEntry tshort = table.getEntry("tshort");
    //sidelength of shortest side of fitted bounding box
    NetworkTableEntry tlong = table.getEntry("tlong");
    //sidelength of longest side of fitted bounding box
    NetworkTableEntry thoriz = table.getEntry("thoriz");
    //horizontal sidelengh of the rough bounding box
    NetworkTableEntry tvert = table.getEntry("tvert");
    //vertical sidelength of the rough bounding box
    


    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double target = tv.getDouble(0.0);
    double s = ts.getDouble(0.0);
    double latency = tl.getDouble(0.0);
    double shortF = tshort.getDouble(0.0);
    double longF = tlong.getDouble(0.0);
    double horizonalR = thoriz.getDouble(0.0);
    double verticalR = tvert.getDouble(0.0);
    
    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("LimelightTarget", target);
    SmartDashboard.putNumber("LimelightSkew/Rotation", s);
    SmartDashboard.putNumber("LimelightLatency", latency);
    SmartDashboard.putNumber("LimelightLengthShort", shortF);
    SmartDashboard.putNumber("LimelightLengthLong", longF);
    SmartDashboard.putNumber("LimelightLengthHorizonal", horizonalR);
    SmartDashboard.putNumber("LimelightLengthVertical", verticalR);

    //System.out.println("x is"+ x+ "y is"+ y+ "area is"+ area);

  }
  public double gettx(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    return tx.getDouble(0.0);
  }
}
