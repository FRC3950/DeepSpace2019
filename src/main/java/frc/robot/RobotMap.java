/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SPI;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static CANSparkMax frontLeft = new CANSparkMax(3, MotorType.kBrushless);
  public static CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
  public static CANSparkMax frontRight = new CANSparkMax(1, MotorType.kBrushless);
  public static CANSparkMax backRight = new CANSparkMax(0, MotorType.kBrushless);

  public static DigitalInput rightSensor = new DigitalInput(4);
  public static DigitalInput centerSensor = new DigitalInput(5);
  public static DigitalInput leftSensor = new DigitalInput(6);

  public static AnalogInput distanceSensor = new AnalogInput(0);

  public static DigitalOutput leftUltraSonicTrigger = new DigitalOutput(8);
  public static DigitalInput leftUltraSonicEcho = new DigitalInput(7);

  // public static AHRS ahrs = new AHRS(SPI.Port.kMXP);

  // Motors and Pnuematics for intake
  // public static WPI_TalonSRX intakeMotor = new WPI_TalonSRX(0);
  // public static DoubleSolenoid liftIntakeSolenoid1 = new DoubleSolenoid(0,1);
  // public static DoubleSolenoid liftIntakeSolenoid2 = new DoubleSolenoid(0,0);
  // public static DoubleSolenoid hatchOuttakeSolenoid1 = new DoubleSolenoid(0,0);
  // public static DoubleSolenoid hatchOuttakeSolenoid2 = new DoubleSolenoid(0,0);
  // public static DoubleSolenoid ninjaStarSolenoid = new DoubleSolenoid(0,0);

  //Motors and Pnuematics for Lift Mechanism
  //  public static WPI_TalonSRX liftMotor = new WPI_TalonSRX(1);
  //  public static Solenoid backLeftLiftSolenoid = new Solenoid(0);
  //  public static Solenoid backRightLiftSolenoid = new Solenoid(1);
  //  public static Solenoid frontLeftLiftSolenoid = new Solenoid(2);
  //  public static Solenoid frontRightLiftSolenoid = new Solenoid(3);

  // public static WPI_TalonSRX ballElevatorMotor = new WPI_TalonSRX(2);
  // public static Solenoid ballElevatorSolenoid = new Solenoid(5);
  // public static DigitalInput bottomLimitSwitch = new DigitalInput(2);
  // public static DigitalInput topLimitSwitch = new DigitalInput(3);

  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
