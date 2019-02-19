/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PIDOutputRotation;
import frc.robot.PIDSourceRotation;
import frc.robot.Robot;
import com.kauailabs.navx.frc.AHRS;


public class RotationPIDCommand extends Command {
  
  double P = SmartDashboard.getNumber("P (lineFollower)",0.0);
  double I = SmartDashboard.getNumber("I (lineFollower)",0.0); 
  double D = SmartDashboard.getNumber("D (lineFollower)",0.0);
  double F = SmartDashboard.getNumber("F (lineFollower)",0.7);

  private PIDController gyroPid;
  double setpoint = 0;
  PIDSourceRotation source;
  int range = 10;
  double robotAngle = 0;
  double rotateTo = 0;

  private double gyroOutput = Double.MAX_VALUE;
  double maxSpeed = 1.6;

  public RotationPIDCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.gyroSubsystem);
    source = new PIDSourceRotation();

    source = new PIDSourceRotation() {

      public void setPIDSourceType(PIDSourceType pidSource) {
      }

      public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
      }

      public double pidGet() {
        System.out.println("yaw: " + Robot.gyroSubsystem.ahrs.getYaw());
        return Robot.gyroSubsystem.ahrs.getYaw();

      }
    
    };

    PIDOutputRotation gyroOut = new PIDOutputRotation() {
      @Override
      public void pidWrite(double output) {
        gyroOutput = output;
        System.out.println("the output is: " + gyroOutput);
      }
  
    };
  
    gyroPid = new PIDController(P, I, D, F, source, gyroOut);

  }



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    robotAngle = Robot.gyroSubsystem.getCurrentAngle();

    setpoint = Robot.gyroSubsystem.ahrs.getYaw();
    System.out.println("in rotation pid init");
    Robot.gyroSubsystem.ahrs.reset();

    source.setPIDSourceType(PIDSourceType.kDisplacement);
    gyroPid.setInputRange(0f, setpoint); //can multiply by 1.tolerance
    gyroPid.setOutputRange(0f, maxSpeed);
    gyroPid.setPercentTolerance(2); //smaller values are better 
    gyroPid.setContinuous(false); //treats range value as one continuous point
    gyroPid.setPID(P, I, D, F); //change values above
    gyroPid.setSetpoint(setpoint);
    gyroPid.enable();

    if (robotAngle > -22.5 && robotAngle < 22.5) {
      setpoint = 0;
   } else if (robotAngle > -67.5 && robotAngle < -22.5) {
    setpoint = -45;
   } else if (robotAngle > -112.5 && robotAngle < -67.5) {
    setpoint = -90;
   } else if (robotAngle > -157.5 && robotAngle < -112.5) {
    setpoint = -135;
   } else if (robotAngle > 157.5 && robotAngle < -157.5) {
    setpoint = -180;
   } else if (robotAngle > 22.5 && robotAngle > 67.5) {
    setpoint = 45;
   } else if (robotAngle > 67.5 && robotAngle < 112.5) {
    setpoint = 90;
   } else if (robotAngle > 112.5 && robotAngle < 157.5) {
    setpoint = 135;
   } else if (robotAngle > 157.5 && robotAngle < -157.5) {
    setpoint = 180;
   }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(gyroOutput != Double.MAX_VALUE) {
      Robot.drivetrainSubsystem.Drive(0, 0, 0, gyroOutput);	
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return gyroPid.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrainSubsystem.Drive(0, 0, 0, 0); //replace with any values?
    gyroPid.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrainSubsystem.Drive(0, 0, 0, 0); //replace with any values?
    gyroPid.disable();
  }

}
