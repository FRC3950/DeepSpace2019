/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ElevatorHeightCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.HatchReleaseCommand;
import frc.robot.subsystems.BallElevatorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.IntakeMotorSubsystem;
import frc.robot.subsystems.IntakePnuematicsSubsystem;
import frc.robot.subsystems.LineFollowerSubsystem;
import frc.robot.subsystems.RobotLiftSubsystem;
import frc.robot.subsystems.USBCameraSubsystem;
import frc.robot.commands.USBCameraCommand;
// import frc.robot.subsystems.BallShooterSubsystemV2;
// import frc.robot.subsystems.UltrasonicSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  
  // public static LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  public static OI m_oi;
  public static HatchButton hatchButton;
  public static BallElevatorSubsystem ballElevatorSubsystem = new BallElevatorSubsystem();
  public static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  public static IntakeMotorSubsystem intakeMotorSubsystem = new IntakeMotorSubsystem();
  public static IntakePnuematicsSubsystem intakePnuematicsSubsystem = new IntakePnuematicsSubsystem();
  public static LineFollowerSubsystem lineFollowerSubsystem = new LineFollowerSubsystem();
  public static RobotLiftSubsystem robotLiftSubsystem = new RobotLiftSubsystem();
  public static USBCameraSubsystem usbCameraSubsystem = new USBCameraSubsystem();
  public static GyroSubsystem gyroSubsystem = new GyroSubsystem();

  public static ElevatorHeightCommand elevatorHeightCommand = new ElevatorHeightCommand(0);
  public static HatchReleaseCommand hatchReleaseCommand = new HatchReleaseCommand();
   // public static UltrasonicSubsystem ultrasonicSubsystem = new UltrasonicSubsystem();
  // public static BallShooterSubsystemV2 ballShooterSubsystemV2 = new BallShooterSubsystemV2(); 


  Command m_autonomousCommand = null;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.set(false);
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    final double Kp = 0.3;
    // edit the p value
    final double Ki = 0.0;
    final double Kd = 0.0;
    
    double fLVelocity = Robot.drivetrainSubsystem.frontLeft.getEncoder().getVelocity();
    double fRVelocity =Robot.drivetrainSubsystem.frontRight.getEncoder().getVelocity();
    double bLVelocity =Robot.drivetrainSubsystem.backLeft.getEncoder().getVelocity();
    double bRVelocity = Robot.drivetrainSubsystem.backRight.getEncoder().getVelocity();

    PIDController leftFrontPID = new PIDController(Kp, Ki, Kd, fLVelocity, Robot.drivetrainSubsystem.frontLeft);
    PIDController rightFrontPID =  new PIDController(Kp, Ki, Kd, fRVelocity, Robot.drivetrainSubsystem.frontRight);
    PIDController leftBackPID =  new PIDController(Kp, Ki, Kd, bLVelocity, Robot.drivetrainSubsystem.backLeft);
    PIDController rightBackPID =  new PIDController(Kp, Ki, Kd, bRVelocity, Robot.drivetrainSubsystem.backRight);

    leftFrontPID.enable();
    rightBackPID.enable();
    rightFrontPID.enable();
    rightBackPID.enable();

    
    //System.out.println(Robot.ballElevatorSubsystem.ballElevatorMotor.getSelectedSensorVelocity());

    if(Robot.ballElevatorSubsystem.ballElevatorMotor.getOutputCurrent() >= 40){
      Robot.elevatorHeightCommand.finished = true;
       }

    SmartDashboard.putNumber("Pressure", (RobotMap.pressureReader.getVoltage() * 56.471 -28.518));
    SmartDashboard.putBoolean("Ball Sensor", Robot.ballElevatorSubsystem.isBallIn());
    // boolean fLS = SmartDashboard.putBoolean("Front Left Sensor" + false, !Robot.lineFollowerSubsystem.getFrontLeftSensor());
    // boolean fCS = SmartDashboard.putBoolean("Front Center Sensor" + false, !Robot.lineFollowerSubsystem.getFrontCenterSensor());
    // boolean fRS = SmartDashboard.putBoolean("Front Right Sensor" + false, !Robot.lineFollowerSubsystem.getFrontRightSensor());
    // boolean bLS = SmartDashboard.putBoolean("Back Left Sensor" + false, !Robot.lineFollowerSubsystem.getBackLeftSensor());
    // boolean bCS = SmartDashboard.putBoolean("Back Center Sensor" + false, !Robot.lineFollowerSubsystem.getBackCenterSensor());
    // boolean bRS = SmartDashboard.putBoolean("Back Right Sensor" + false, !Robot.lineFollowerSubsystem.getBackRightSensor());
    SmartDashboard.putBoolean("Ninja Star" , !Robot.intakePnuematicsSubsystem.ninjaStarSolenoid.get());
    // boolean lBNS = SmartDashboard.putBoolean("Left Button" + false, Robot.intakePnuematicsSubsystem.isHatchLeftLinedUp());
    // boolean rBNS = SmartDashboard.putBoolean("Right Button" + false, Robot.intakePnuematicsSubsystem.isHatchRightLinedUp());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
   //((USBCameraCommand)m_autonomousCommand).finished = true;
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
//    m_autonomousCommand = m_chooser.getSelected();
    m_autonomousCommand = new USBCameraCommand();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    ((USBCameraCommand)m_autonomousCommand).finished = true;
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    Robot.robotLiftSubsystem.backLeftLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    Robot.robotLiftSubsystem.backRightLiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    Robot.robotLiftSubsystem.frontLeftLiftSolenoid.set(DoubleSolenoid.Value.kForward);
    Robot.robotLiftSubsystem.frontRightLiftSolenoid.set(DoubleSolenoid.Value.kForward);
    // Robot.intakePnuematicsSubsystem.intakeLeftRotateSolenoid.set(true);
    // Robot.intakePnuematicsSubsystem.intakeRightRotateSolenoid.set(true);
    // Robot.drivetrainSubsystem.backLeft.getEncoder().setPosition(0.0);
    // Robot.drivetrainSubsystem.frontLeft.getEncoder().setPosition(0.0);
    // Robot.drivetrainSubsystem.backRight.getEncoder().setPosition(0.0);
    // Robot.drivetrainSubsystem.frontRight.getEncoder().setPosition(0.0);

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    

    Scheduler.getInstance().run();
  

    // System.out.println("bl Position" + Robot.drivetrainSubsystem.backLeft.getEncoder().getPosition());
    // System.out.println("fl Position" + Robot.drivetrainSubsystem.frontLeft.getEncoder().getPosition());
    // System.out.println("br Position" + -Robot.drivetrainSubsystem.backRight.getEncoder().getPosition());
    // System.out.println("fr Position" + -Robot.drivetrainSubsystem.frontRight.getEncoder().getPosition());
    //System.out.println("L=" + RobotMap.leftLight.get() + " C=" + RobotMap.centerLight.get() + " R=" + RobotMap.rightLight.get());
    //System.out.println("L=" + RobotMap.leftSensor.get() + " C=" + RobotMap.centerSensor.get() + " R=" + RobotMap.rightSensor.get());
  }

  /**
   * This function is called periodically during test mode.
   */
  boolean started = false;
  @Override
  public void testPeriodic() {
    // if(!started) {
    //   started = true;
    //   Robot.drivetrainSubsystem.frontLeft.setInverted(true);
    //   Robot.drivetrainSubsystem.frontRight.setInverted(true);
    //   Robot.drivetrainSubsystem.frontLeft.set(0.5);
    //   Robot.drivetrainSubsystem.backLeft.set(0.5);
    //   Robot.drivetrainSubsystem.frontRight.set(0.5);
    //   Robot.drivetrainSubsystem.backRight.set(0.5);
    //   System.out.println("fL=" + Robot.drivetrainSubsystem.frontLeft.isFollower());
    //   System.out.println("fR=" + Robot.drivetrainSubsystem.frontRight.isFollower());
    //   System.out.println("bL=" + Robot.drivetrainSubsystem.backLeft.isFollower());
    //   System.out.println("bR=" + Robot.drivetrainSubsystem.backRight.isFollower());


    
  //   System.out.println("fL " + Robot.drivetrainSubsystem.frontLeft.get());
  //   System.out.println("bL " + Robot.drivetrainSubsystem.backLeft.getEncoder().getVelocity());
  //   System.out.println("fR " + Robot.drivetrainSubsystem.frontRight.getEncoder().getVelocity());
  //   System.out.println("bR " + Robot.drivetrainSubsystem.backRight.getEncoder().getVelocity());
   }
}
