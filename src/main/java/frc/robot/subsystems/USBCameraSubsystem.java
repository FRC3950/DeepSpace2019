/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class USBCameraSubsystem extends Subsystem {
  private static UsbCamera camera = null;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    camera = CameraServer.getInstance().startAutomaticCapture(0);
    camera.setResolution(640,480);

    CvSink cvSink = CameraServer.getInstance().getVideo();
    CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);

    Mat source = new Mat();
    Mat output = new Mat();

    //while(!Thread.interrupted()) {
    //  cvSink.grabFrame(source);
    //  Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
    //  outputStream.putFrame(output);
    //}

     // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
   
  }
}