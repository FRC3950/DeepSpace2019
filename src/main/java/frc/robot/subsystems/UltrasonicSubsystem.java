/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import java.lang.Math;
import java.util.Arrays;

/**
 * Add your docs here.
 */
public class UltrasonicSubsystem extends Subsystem {
  SerialPort serialPort = null;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    RobotMap.leftUltraSonicTrigger.set(false);
    serialPort = new SerialPort(9600, Port.kUSB1);
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
    // double dL = getLeftDistance();
    // double dR = getRightDistance();
    // double W = 10.0f;
    // return Math.atan((dL-dR)/ W);
    return robotAngle;
  }
  private static double detectorWidth = 10.75;
  private double robotAngle = 0.0;
  private double[] robotAngles = new double[100];
  private int robotAnglesCounter = 0;
  public double getAnalogDistance(){
    double distance = 0.0;
  //  RobotMap.distanceSensor.resetAccumulator();
  //  System.out.println("V=" + RobotMap.distanceSensor.getAverageVoltage());
  //  return RobotMap.distanceSensor.getAverageVoltage() / .0098;
    if(serialPort != null){
      String data = serialPort.readString();
      if(data != null && !data.isEmpty()) {
        // System.out.println("hello");
        // System.out.println("bytesRead =" + data);
        String[] dataArr = data.split("\n");
        if(dataArr != null && dataArr.length > 0){
          String [] leftRightData = dataArr[dataArr.length - 1].split(",");
          if (leftRightData != null && leftRightData.length == 2) {
            Double distanceLeft = Double.valueOf(leftRightData[0]);
            Double distanceRight = Double.valueOf(leftRightData[1]);
            robotAngle = Math.toDegrees(Math.atan((distanceLeft - distanceRight)/ detectorWidth));
            distance = Math.min(distanceLeft, distanceRight) + Math.abs(distanceLeft - distanceRight) / 2;
            //System.out.println("dL=" + distanceLeft + "  dR=" + distanceRight + "  W=" + detectorWidth);
            if(robotAnglesCounter == 100){
              System.out.println("max=" + Arrays.stream(robotAngles).max() + "  min=" + Arrays.stream(robotAngles).min() + "  avg=" + Arrays.stream(robotAngles).average());
              robotAnglesCounter = 0;
            }
            robotAngles[robotAnglesCounter++] = robotAngle;
          }
        }
      }
    }
//    int bytesToRead = P.getBytesReceived();
//    if (bytesToRead > 0) {
//      byte [] bytesRead = P.read(bytesToRead);
//      if(bytesRead != null && bytesRead.length > 0){
//        System.out.println("bytesRead =" + new String(bytesRead));
//      }
//    } else {
//      System.out.println("bytesRead = 0");
//    }
//    P.close();
    return distance;
  }
}