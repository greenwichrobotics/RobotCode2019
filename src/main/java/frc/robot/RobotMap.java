/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // PWM
  // Drive motors
  public static int frontLeft = 0;
  public static int rearLeft = 1;
  public static int frontRight = 2;
  public static int rearRight = 3;
  public static int frontClimberMotor = 4;
  public static int backClimberMotor = 5;
  public static int howWheelsMotor = 6;
  public static int hatchRaiseMotor = 7;
  public static int hatchTurnMotor = 8;
  public static int elevatorMotor = 9;
  
  // DIO
  public static int frontClimberSwitch = 0;
  public static int backClimberSwitch = 1;
  public static int hotWheelsEncoderA = 2;
  public static int hotWheelsEncoderB = 3;
  public static int upperSwitch = 4;
  public static int lowerSwitch = 5;
  public static int hatchMotorRaiseEncoderA = 6;
  public static int hatchMotorRaiseEncoderB = 7;
  public static int hatchTurnMotorEncoderA = 8;
  public static int hatchTurnMotorEncoderB = 9; 

<<<<<<< HEAD
  public static int hatchMotor = 4;
  public static int armEncoderA = 0;
  public static int armEncoderB = 1;
  public static int upperSwitch = 7;
  public static int lowerSwitch = 8;

  public static int hatchRaiseMotor = 4; //PWM
  public static int hatchTurnMotor = 5; //PWM
  public static int hatchMotorRaiseEncoderA = 2; //DIO
  public static int hatchMotorRaiseEncoderB = 3; //DIO
  public static int hatchTurnMotorEncoderA = 4; //DIO
  public static int hatchTurnMotorEncoderB = 5; //DIO
=======
>>>>>>> sg

  //USB
  public static int pilotControllerPort = 0;
  public static int copilotControllerPort = 1;

}
