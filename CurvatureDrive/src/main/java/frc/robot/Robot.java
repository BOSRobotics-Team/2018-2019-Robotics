/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.GroupMotorControllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  WPI_VictorSPX LeftVictor1=new WPI_VictorSPX(1);
  WPI_VictorSPX LeftVictor2=new WPI_VictorSPX(4);
  WPI_VictorSPX RightVictor1=new WPI_VictorSPX(2);
  WPI_VictorSPX RightVictor2=new WPI_VictorSPX(3);
  WPI_VictorSPX ArmSwing=new WPI_VictorSPX(0);
  
  SpeedControllerGroup LeftVictors=new SpeedControllerGroup(LeftVictor1, LeftVictor2);
  SpeedControllerGroup RightVictors=new SpeedControllerGroup(RightVictor1, RightVictor2);
  
  DifferentialDrive Drive=new DifferentialDrive(LeftVictors, RightVictors);

  Joystick Controller = new Joystick(0);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    LeftVictor1.set(ControlMode.PercentOutput, 0);
    LeftVictor2.set(ControlMode.PercentOutput, 0);
    RightVictor1.set(ControlMode.PercentOutput, 0);
    RightVictor2.set(ControlMode.PercentOutput, 0);
    ArmSwing.set(ControlMode.PercentOutput, 0);
//This String of Code is used to make the motors not move on start up
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture(); //Camera CODE
}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    System.out.println("Wow");
  }

  @Override
  public void teleopPeriodic() {
    double leftStick=Controller.getRawAxis(1)*-1;
    double rightStick=Controller.getRawAxis(4);
    double xSpeed=Math.pow(leftStick, 2);
    double zRotation=Math.pow(zRotation, 2)

    if(leftStick < 0){
      Drive.arcadeDrive(-xSpeed, zRotation);
    }
    if(rightStick < 0){
      Drive.arcadeDrive(xSpeed, -zRotation);
    }
    if(leftStick < 0 && rightStick < 0){
      Drive.arcadeDrive(-xSpeed, -zRotation);
    }
    else{
      Drive.arcadeDrive(xSpeed, zRotation);
    }
    
    boolean SwingUp = Controller.getRawButtonPressed(4);

    if(SwingUp==true){
      
    }
}

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
