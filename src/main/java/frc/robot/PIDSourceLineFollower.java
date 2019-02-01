/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * Add your docs here.
 */
public class PIDSourceLineFollower implements PIDSource {
    PIDSourceType type;
    AHRS navx;
    public PIDSourceLineFollower(){
        navx = RobotMap.ahrs;
    }
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		type = pidSource;
	}
	@Override
	public PIDSourceType getPIDSourceType() {
		return type;
	}
	@Override
	public double pidGet() {
		return navx.getYaw();
    }
    public void reset(){
        navx.zeroYaw();
        navx.reset();
    }

}
