/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    //RobotMap.leftUltraSonicTrigger.set(false);
  }

  public int getLineFollowerState() {
    boolean centerSensor = !RobotMap.centerSensor.get();
    boolean leftSensor = !RobotMap.leftSensor.get();
    boolean rightSensor = !RobotMap.rightSensor.get();
    //gets the negation of the left, right, and center sensors
    int currentState = ((leftSensor ? 1 : 0) << 2) | (centerSensor ? 1 : 0) << 1  | (rightSensor ? 1 : 0) << 0;
    System.out.println("leftSensor=" + leftSensor + "  centerSensor=" + centerSensor + "  rightSensor=" +rightSensor);
    //prints the current state of the left, right, and center sensors
    return currentState;
  }

  public boolean getLeftSensor() {
    return RobotMap.leftSensor.get();
  }
  public boolean getCenterSensor() {
    return RobotMap.centerSensor.get();
  }
  public boolean getRightSensor() {
    return RobotMap.rightSensor.get();
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
  // public float getRightDistance(){
  //   return 0.0f;
  //   //gets right distance
  // }
  // public double getRobotAngle(){
  //   double dL = getLeftDistance();
  //   //gets distance from left ultrasonic sensor
  //   double dR = getRightDistance();
  //   //gets distance from right ultrasonic sensor
  //   double W = 10.0f;
  //   //sets distance between the ultrasonic sensor
  //   return Math.atan((dL-dR)/ W);
  //   //returns the distance from the center of the robot
    
  // }
}
