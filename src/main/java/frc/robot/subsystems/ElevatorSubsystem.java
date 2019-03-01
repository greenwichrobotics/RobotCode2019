/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  Spark liftMotorController;
  DigitalInput liftSwitchA;
  DigitalInput liftSwitchB;
  int level = 1;
  double upSpeed = 0.5;
  double downSpeed = -0.5;

  public ElevatorSubsystem(){
    liftMotorController = new Spark(RobotMap.frontClimberMotor); //todo: replace with elevator motor
    liftSwitchA = new DigitalInput(RobotMap.upperSwitch);
    liftSwitchB = new DigitalInput(RobotMap.lowerSwitch);

  }

  public void goToLevel1(){
    if(level == 2){
      goDown();
      level = 1;
    
    }
    else if(level == 3){
      goDown();
      goDown();
      level = 1;
  
    }
  }

  public void goToLevel2(){
    if(level == 1){
      goUp();
      level = 2;
 
    }
    else if(level == 3){
      goDown();
      level = 2;
    
    }
  }

  public void goToLevel3(){
    if(level == 1){
      goUp();
      goUp();
      level = 3;
     
    }
    else if(level == 2){
      goUp();
      level = 3;
      
    }
  }

    public void goUp(){
      while(!getliftSwitchA()){
        liftMotorController.set(upSpeed);
      }

    }
    
    public void goDown(){
      while(!getliftSwitchB()){
        liftMotorController.set(downSpeed);
      }      
    }

    public boolean getliftSwitchA(){
      return liftSwitchA.get();
    }

    public boolean getliftSwitchB(){
      return liftSwitchB.get();
    }

 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}