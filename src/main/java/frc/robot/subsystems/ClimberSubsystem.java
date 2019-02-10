/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class ClimberSubsystem extends Subsystem {
  Spark frontClimberMotorController;
  Spark backClimberMotorController;
  Encoder hotWheelsEncoder;
  int level = 1;
  DigitalInput frontClimberSwitch;
  DigitalInput backClimberSwitch;
  Spark hotWheelsMotorController;
  double climberUpSpeed = 0.5;
  double climberDownSpeed = -0.5;
  double hotWheelsForwardSpeed = 0.5;
  double hotWheelsBackwardSpeed = -0.5;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public ClimberSubsystem()
  {
    frontClimberMotorController = new Spark(RobotMap.frontClimberMotor);
    backClimberMotorController = new Spark(RobotMap.frontClimberMotor);
    hotWheelsEncoder = new Encoder(RobotMap.hotWheelsEncoderA,RobotMap.hotWheelsEncoderB);
    frontClimberSwitch = new DigitalInput(RobotMap.frontClimberSwitch);
    backClimberSwitch = new DigitalInput(RobotMap.backClimberSwitch);
    hotWheelsMotorController = new Spark(RobotMap.howWheelsMotor);

  }
  
  public void ClimberLevel1(int location)
  {
      // when level 1 do nothing
      // at level 2 go down 1 switch
      // at level 3 go down 3 switch
    if(level == 2)
    {
      moveDown(location);
      level = 1;
    }
    else if(level == 3)
    {
      moveDown(location);
      moveDown(location);
      level = 1;
    }
      
  }

  public void ClimberLevel2(int location)
  {
    if(level == 1)
    {
      moveUp(location);
      level = 2;
    } 
    else if(level == 3)
    {
      moveDown(location);
      level = 2;
    }
  }

  public void ClimberLevel3(int location)
  {
    if(level == 1)
    {
      moveUp(location);
      moveUp(location);
      level = 3;
    }
    else if(level == 2)
    {
      moveUp(location);
      level = 3;
    }
  }

  public void moveUp(int location)
  {
    if(location == 1)
    {
      while(!frontClimberSwitch.get())
      {frontClimberMotorController.set(climberUpSpeed);}
      backClimberMotorController.set(0);
    }
    else if(location == 2)
    {
      while (!backClimberSwitch.get())
        {backClimberMotorController.set(climberUpSpeed);}
      backClimberMotorController.set(0);
    }
    else
    {
    while (!backClimberSwitch.get() && !frontClimberSwitch.get())
     {
      backClimberMotorController.set(climberUpSpeed);
      frontClimberMotorController.set(climberUpSpeed);
     }

     backClimberMotorController.set(0);
     frontClimberMotorController.set(0);
      
    }
}

  public void moveDown(int location)
  {
    if(location == 1)
    {
    while(!frontClimberSwitch.get())
     {frontClimberMotorController.set(climberDownSpeed);}
      frontClimberMotorController.set(0);
    }

    else if(location == 2)
    {
    while (!backClimberSwitch.get())
     {backClimberMotorController.set(climberDownSpeed);}
      backClimberMotorController.set(0);
    }
    else
    {
        while (!backClimberSwitch.get() && !frontClimberSwitch.get())
    {
      backClimberMotorController.set(climberDownSpeed);
      frontClimberMotorController.set(climberDownSpeed);
    }

     backClimberMotorController.set(0);
     frontClimberMotorController.set(0);
    }
  }
 
  public void hotWheelsForward()
  {
    hotWheelsMotorController.set(hotWheelsForwardSpeed);
    hotWheelsMotorController.set(0);
  }

  public void hotWheelsBackward()
  {
    hotWheelsMotorController.set(hotWheelsBackwardSpeed);
    hotWheelsMotorController.set(0);
  }
  @Override
  public void initDefaultCommand() {                                                            
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

/**
 * 
 * When (X) Button Pushed
 *    Rise (Front and Back Pillars) Until Switch Detected
 * When (X) Button pushed Again 
 *    Rise (Fron tand Back Pillars) Until Switch Detected
 * 
 * When (Y) Button Pushed
 *    Hot Wheels Forward Until Front Wheels Are Supported by the HAB
 *    Raise Front Pillars
 *    Hot Wheels Forward Until Center Wheels Are Supported by the HAB
 *    Raise Back Pillars
 *    Drive Forward (Normal Drivetrain)
 * 
 * DRIVING OFF
 * Drive back until back wheels are hanging off 
 *  Drop back pillars
 * Drive back until center wheels are hanging off
 *  Drop front pillars
 *
 *    
 */