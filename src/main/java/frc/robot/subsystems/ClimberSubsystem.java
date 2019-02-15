/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
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
  double hotWheelsForwardSpeed = 0.1;
  double hotWheelsBackwardSpeed = -0.1;
  int forwardDistance = 0;
  int backwardDistance = 0;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public ClimberSubsystem()
  {
    frontClimberMotorController = new Spark(RobotMap.frontClimberMotor);
    backClimberMotorController = new Spark(RobotMap.backClimberMotor);
    hotWheelsEncoder = new Encoder(RobotMap.hotWheelsEncoderA,RobotMap.hotWheelsEncoderB);
    frontClimberSwitch = new DigitalInput(RobotMap.frontClimberSwitch);
    backClimberSwitch = new DigitalInput(RobotMap.backClimberSwitch);
    hotWheelsMotorController = new Spark(RobotMap.howWheelsMotor);

  }
  
  public void ClimberLevel1(int location) // If you want to climb to level 1, it goes down once if it is currently at level 2, and goes down twice if it is currently at level 3.
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

  public void ClimberLevel2(int location) // If you want to climb to level 2, it goes up once if it is currently at level 1, and goes down once if it is currently at level 3.
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

  public void ClimberLevel3(int location) // If you want to climb to level 3, it goes up twice if it is currently at level 1 and goes up once if it is currently at level 2.
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
    if(location == 1)                                                        // Allow front climbers to be moved
    {
      while(!frontClimberSwitch.get())
      {frontClimberMotorController.set(climberUpSpeed);}
      backClimberMotorController.set(0);
    }
    else if(location == 2)                                                 // Allow back climbers to be moved                                       
    {
      while (!backClimberSwitch.get())                                   
        {backClimberMotorController.set(climberUpSpeed);}
      backClimberMotorController.set(0);
    }
    else                                                                 // Allow both climbers to be moved at the same time
    {
    while (!backClimberSwitch.get() && !frontClimberSwitch.get())
      backClimberMotorController.set(climberUpSpeed);
      frontClimberMotorController.set(climberUpSpeed);
     }

     backClimberMotorController.set(0);
     frontClimberMotorController.set(0);
      
    }

  public void moveDown(int location)
  {
    if(location == 1)                                             // FRONT CLIMBER
    {
    while(!frontClimberSwitch.get())
     {frontClimberMotorController.set(climberDownSpeed);}
      frontClimberMotorController.set(0);
    }

    else if(location == 2)                                      // BACK CLIMBER
    {
    while (!backClimberSwitch.get())
     {backClimberMotorController.set(climberDownSpeed);}
      backClimberMotorController.set(0);
    }
    else                                                      // BOTH FRONT AND BACK CLIMBER
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
    Timer.delay(forwardDistance);
    hotWheelsMotorController.set(0);
  }

  public void hotWheelsBackward()
  {
    hotWheelsMotorController.set(hotWheelsBackwardSpeed);
    Timer.delay(backwardDistance);
    hotWheelsMotorController.set(0);
  }
  public void testUp()
  {
    frontClimberMotorController.set(climberUpSpeed);
    backClimberMotorController.set(climberUpSpeed);
  }
  public void testDown()
  {
    frontClimberMotorController.set(climberDownSpeed);
    backClimberMotorController.set(climberDownSpeed);
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