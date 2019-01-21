/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import java.lang.Math;

/**
 * Add your docs here.
 */
public class LineFollowerSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    RobotMap.leftUltraSonicTrigger.set(false);
  }

  public int getLineFollowerState() {
    boolean centerCamera = !RobotMap.centerCamera.get();
    boolean leftCamera = !RobotMap.leftCamera.get();
    boolean rightCamera = !RobotMap.rightCamera.get();
    int currentState = ((leftCamera ? 1 : 0) << 2) | (centerCamera ? 1 : 0) << 1  | (rightCamera ? 1 : 0) << 0;
    System.out.println("leftCamera=" + leftCamera + "  centerCamera=" + centerCamera + "  rightCamera=" +rightCamera);
    
    return currentState;
  }

  public float getLeftDistance(){
    RobotMap.leftUltraSonicTrigger.set(true);
    try {
      Thread.sleep((long)0.01);
    }
    catch(Exception ex)
    {
    }
    RobotMap.leftUltraSonicTrigger.set(false);
    while(RobotMap.leftUltraSonicEcho.get() == false) {
    }
    long startTime = System.nanoTime();
    while(RobotMap.leftUltraSonicEcho.get() == true) {
    }
    long endTime = System.nanoTime();
    System.out.println("startTime=" + startTime + "  endTime=" + endTime + "  distance=" + ((endTime - startTime)/1e3)/2/29.1/2.54);
        return 0.0f;
  }
  public float getRightDistance(){
    return 0.0f;
  }
  public double getRobotAngle(){
    double dL = getLeftDistance();
    double dR = getRightDistance();
    double W = 10.0f;
    return Math.atan((dL-dR)/ W);
  }
}
