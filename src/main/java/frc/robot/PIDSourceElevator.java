package frc.robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class PIDSourceElevator implements PIDSource {

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		//pidSource = PIDSourceType.kDisplacement;
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return Robot.ballElevatorSubsystem.getElevatorHeight();
	}

}