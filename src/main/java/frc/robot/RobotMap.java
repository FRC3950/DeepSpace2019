/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(0);
  //public static WPI_TalonSRX backLeft = new WPI_TalonSRX(1);
  //public static WPI_TalonSRX frontRight = new WPI_TalonSRX(2);
  //public static WPI_TalonSRX backRight = new WPI_TalonSRX(3);

  public static CANSparkMax frontLeft = new CANSparkMax(0, MotorType.kBrushless);
  public static CANSparkMax backLeft = new CANSparkMax(1, MotorType.kBrushless);
  public static CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);
  public static CANSparkMax backRight = new CANSparkMax(3, MotorType.kBrushless);

  public static DigitalInput centerLight = new DigitalInput(1);
  public static DigitalInput leftLight = new DigitalInput(2);
  public static DigitalInput rightLight = new DigitalInput(0);
  
  public static DigitalInput rightCamera = new DigitalInput(3);
  public static DigitalInput centerCamera = new DigitalInput(4);
  public static DigitalInput leftCamera = new DigitalInput(5);

  public static DigitalOutput leftUltraSonicTrigger = new DigitalOutput(6);
  public static DigitalInput leftUltraSonicEcho = new DigitalInput(7);

  public static AHRS ahrs = new AHRS(SPI.Port.kMXP);

  public static WPI_TalonSRX intakeMotor = new WPI_TalonSRX(0);

  public static DoubleSolenoid liftIntakeSolenoid1 = new DoubleSolenoid(0,0);
  public static DoubleSolenoid liftIntakeSolenoid2 = new DoubleSolenoid(0,0);
  public static DoubleSolenoid hatchOuttakeSolenoid1 = new DoubleSolenoid(0,0);
  public static DoubleSolenoid hatchOuttakeSolenoid2 = new DoubleSolenoid(0,0);
  public static DoubleSolenoid ninjaStarSolenoid = new DoubleSolenoid(0,0);

  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
