/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchClawSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSP hatchMotorRaiseController;
  Encoder hatchMotorRaiseEncoder;
  VictorSP hatchTurnMotorController;
  Encoder hatchTurnMotorEncoder;

  public HatchClawSubsystem() {
    hatchMotorRaiseController = new VictorSP(RobotMap.hatchRaiseMotor);
    hatchMotorRaiseEncoder = new Encoder(RobotMap.hatchMotorRaiseEncoderA, RobotMap.hatchMotorRaiseEncoderB);
    hatchTurnMotorController = new VictorSP(RobotMap.hatchTurnMotor);
    hatchTurnMotorEncoder = new Encoder(RobotMap.hatchTurnMotorEncoderA, RobotMap.hatchTurnMotorEncoderB);
  }
  public void turnClockwise() {
    hatchMotorRaiseEncoder.reset();
    //250 is half way
    while(hatchMotorRaiseEncoder.get() > -103){
    hatchMotorRaiseController.set(-0.3);
  }
  hatchTurnMotorController.set(0);
  hatchTurnMotorEncoder.reset();
  //250 is half way
  while(hatchTurnMotorEncoder.get() > -250){
  hatchTurnMotorController.set(-0.5);
}
hatchTurnMotorController.set(0);
  }

  public void turnCounterclockwise(){
    hatchMotorRaiseEncoder.reset();
    while(hatchMotorRaiseEncoder.get() < 103){
    hatchMotorRaiseController.set(0.3);
  }
  hatchMotorRaiseController.set(0); 
 
  hatchTurnMotorEncoder.reset();
    while(hatchTurnMotorEncoder.get() < 103){
    hatchTurnMotorController.set(0.5);
  }
  hatchTurnMotorController.set(0);  
  }
    //when button is pushed arm lowers because the arm was placed that way
    //if same button is pushed then return to the up original position
    //if same button is pushed while in action the arm stops
    //can only go to two points and no where else
    //takes the "% 2" of the number of times button pushed, if zero then do nothing, if one then store value.
    //when robot starts zero no trun at start, if one then turn to original position
      
    //TURNING MOTOR
    //hand is manually up in start position
    //counts number of times the turn button is pushed
    //hand turns 180 degrees when button pushed
    //takes the "% 2" of the number of times button pushed, if zero then do nothing, if one then store value.
    //when robot starts zero no trun at start, if one then turn to original position

      
  
  
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
