/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeMotorCommand;


/**
 * Add your docs here.
 */
public class IntakeMotorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  final int intakeMotorChannel = 5;
  
  private WPI_TalonSRX intakeMotor = new WPI_TalonSRX(intakeMotorChannel);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new IntakeMotorCommand());
  }
  public void intakeMotorSet(double trigger){
    intakeMotor.set(trigger);
    //sets intake motor to the trigger on the xboxcontroller
  }
}
