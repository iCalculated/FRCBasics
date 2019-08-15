/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * Variables are declared at the top of classses, don't put all of the
   * decalarations in Robot.java as I am doing. 
   * Declarations are a framework for what features are on the robot for 
   * the language, while the later instantiations are actually creating the 
   * objects
   * 
   * This code is based on our 2017 robot, Fracture.
   */
  Spark leftFront, leftBack, rightFront, rightBack, climberMotor;
  MecanumDrive mecanumDrive;  //this is actually going to be a group of motors
  Servo gearSlideMotor;
  Joystick joystick; // note here that we usually have two joysticks
  AHRS navX;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    rightFront = new Spark(0);
    leftBack = new Spark(1);
    leftFront = new Spark(2);
    rightBack = new Spark(3);
    mecanumDrive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);

    joystick = new Joystick(0);
    climberMotor = new Spark(4);

    gearSlideMotor = new Servo(5);

    navX = new AHRS(SPI.Port.kMXP);
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
  public void robotPeriodic() {}

  /**
   * Notably, the two following functions are not used
   * specifically because this is a robot in one file
   * 
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {}

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {}

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {}

  public void drive() {

  }

  public void climb() {

  }

  public void gearDrop() {

  }

  public void gearRaise() {

  }
  
  public void angleFix() {

  }

  public static double limit(double value, double limit) {
    return value > limit ? limit : value < -limit ? -limit : value; 
  }

  public static double angleDifference(double currentAngle, double goalAngle) {
    double diff = goalAngle - currentAngle; 
    assert(diff<360); 
    return diff < -180 ? diff + 360 : diff > 180 ? diff -360 : diff;
  }
}
