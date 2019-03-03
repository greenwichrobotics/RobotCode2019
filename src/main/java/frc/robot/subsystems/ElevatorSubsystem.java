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
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  Spark liftMotorController;
 // DigitalInput liftSwitchA;
  //DigitalInput liftSwitchB;
  Encoder elevatorEncoder;
  int level = 1;
  double upSpeed = 0.5;
  double downSpeed = -0.5;
  int level1 = 1000;
  int level2 = 2000;
  int level3 = 3000;

  public ElevatorSubsystem(){
    liftMotorController = new Spark(RobotMap.elevatorMotor); //todo: replace with elevator motor
    //liftSwitchA = new DigitalInput(RobotMap.upperSwitch);
    //liftSwitchB = new DigitalInput(RobotMap.lowerSwitch);
    elevatorEncoder = new Encoder(RobotMap.elevatorEncoderA, RobotMap.elevatorEncoderB);


  }

  public void goToLevel1(){
    if(level == 2){
      goDown(level1);
      level = 1;
    
    }
    else if(level == 3){
      goDown(level1);
      goDown(level1);
      level = 1;
  
    }
  }

  public void goToLevel2(){
    if(level == 1){
      goUp(level2);
      level = 2;
 
    }
    else if(level == 3){
      goDown(level2);
      level = 2;
    
    }
  }

  public void goToLevel3(){
    if(level == 1){
      goUp(level3);
      goUp(level3);
      level = 3;
     
    }
    else if(level == 2){
      goUp(level3);
      level = 3;
      
    }
  }

    public void goUp(int toLevel){
      while(elevatorEncoder.get() < toLevel){
        liftMotorController.set(upSpeed);
      }

    }
    
    public void goDown(int toLevel){
      while(elevatorEncoder.get() > toLevel){
        liftMotorController.set(downSpeed);
      }      
    }

   
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}