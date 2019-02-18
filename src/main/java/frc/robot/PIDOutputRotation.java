/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * Add your docs here.
 */
public class PIDOutputRotation implements PIDOutput {
    double outsource = 0;
    @Override
    public void pidWrite(double output) {
        outsource = output;        
    }
    public double pidGet() {
        return outsource;
    }
}
