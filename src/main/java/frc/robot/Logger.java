/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Logger {
    public static LogLevel loggerLogLevel = LogLevel.info;
	
	public static void log(String msg) {
		System.out.println(msg);
	}
	
	public enum LogLevel {
		info(0),
		debug(1),
		trace(2),
		error(3);
		private int value;
		private LogLevel(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}

	
	public static void log(LogLevel logLevel, String msg) {
		if (logLevel == LogLevel.error) {
			log(msg);
		} else if (logLevel.getValue() <= Logger.loggerLogLevel.getValue()) {
			log(msg);
		}
	}

}
