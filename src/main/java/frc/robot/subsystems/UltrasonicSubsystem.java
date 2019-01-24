/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import java.lang.Math;

/**
 * Add your docs here.
 */
public class UltrasonicSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    RobotMap.leftUltraSonicTrigger.set(false);
  }

  private long startTime = 0;

  public void resetTrigger() {
    System.out.println("resetTrigger");
    RobotMap.leftUltraSonicTrigger.set(false);
  }

  public void startTrigger() {
    System.out.println("startTrigger");
    RobotMap.leftUltraSonicTrigger.set(true);
    try {
      Thread.sleep((long)0.01);
    }
    catch(Exception ex)
    {
    }
    RobotMap.leftUltraSonicTrigger.set(false);
    startTime = 0;
  }

  public double getLeftDistance(){
    if(RobotMap.leftUltraSonicEcho.get() == false) {
      System.out.println("leftUltraSonicEcho==false waiting for echo processing");
      return -1.0;
    }
//    while(RobotMap.leftUltraSonicEcho.get() == false) {
//    }
    if(startTime == 0) {
      startTime = System.nanoTime();
      System.out.println("leftUltraSonicEcho==true started echo processing");
      return -1.0;
    }
    if(RobotMap.leftUltraSonicEcho.get() == true) {
      System.out.println("leftUltraSonicEcho==true echo processing");
      return -1.0;
    }

      System.out.println("leftUltraSonicEcho==true finished echo processing");
    return ((System.nanoTime() - startTime)/1e3)/2/29.1/2.54;
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
  public double getAnalogDistance(){
    RobotMap.distanceSensor.resetAccumulator();
    System.out.println("V=" + RobotMap.distanceSensor.getAverageVoltage());
    return RobotMap.distanceSensor.getAverageVoltage() / .0098;
  }
}
