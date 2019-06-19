/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.driveStraight;

/**
 * Add your docs here.
 */
public class driveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.  
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(46);
	public WPI_TalonSRX	frontRight = new WPI_TalonSRX(47);
	public WPI_TalonSRX	backLeft = new WPI_TalonSRX(44);
  public WPI_TalonSRX	backRight = new WPI_TalonSRX(49);

  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  public SpeedControllerGroup rightSpeedControllerGroup = new SpeedControllerGroup(frontRight,backRight);
  public SpeedControllerGroup LeftSpeedControllergroup = new SpeedControllerGroup(frontLeft,backLeft);

  public DifferentialDrive drive = new DifferentialDrive(LeftSpeedControllergroup, rightSpeedControllerGroup);

  public void tankDrive(double leftSpeed,double rightSpeed){
    drive.tankDrive(leftSpeed,rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new driveStraight());

  }
}
