/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
  Spark elevatorMotor;
  int encoderUpDownDistance = 70;
  int encoderRotate = 210;

  public HatchClawSubsystem() {
    // elevatorMotor = new Spark(RobotMap.elevatorMotor);
    hatchMotorRaiseController = new VictorSP(RobotMap.hatchRaiseMotor);
    hatchMotorRaiseEncoder = new Encoder(RobotMap.hatchMotorRaiseEncoderA, RobotMap.hatchMotorRaiseEncoderB);
    hatchTurnMotorController = new VictorSP(RobotMap.hatchTurnMotor);
    hatchTurnMotorEncoder = new Encoder(RobotMap.hatchTurnMotorEncoderA, RobotMap.hatchTurnMotorEncoderB);
    hatchTurnMotorEncoder.reset();
    hatchMotorRaiseEncoder.reset();
  }


  public void turnClockwise() {
   
    // 250 is half way
    if ((hatchTurnMotorEncoder.get() < encoderRotate)) {
      hatchTurnMotorController.set(0.3);
      SmartDashboard.putNumber("HatchMotorTurnEncoder:", hatchTurnMotorEncoder.get());
      System.out.println(hatchTurnMotorEncoder.get());
    } else {
      hatchTurnMotorController.set(0);
      hatchTurnMotorEncoder.reset();
    } // 250 is half way
      // while(hatchTurnMotorEncoder.get() > -250){
      // hatchTurnMotorController.set(-0.5);
    // }
    // hatchTurnMotorController.set(0);
  }

  // public void turnCounterclockwise(){
  // hatchTurnMotorEncoder.reset();
  // while(hatchTurnMotorEncoder.get() < 200){
  // hatchTurnMotorController.set(0.3);
  // }
  // hatchTurnMotorController.set(0);
  // hatchTurnMotorEncoder.reset();
  // while(hatchTurnMotorEncoder.get() < 103){
  // hatchTurnMotorController.set(0.5);
  // }
  // hatchTurnMotorController.set(0);
  // }
  //////////////////////////////////
  public void moveUp() {
   
    // 250 is half way
    if ((hatchMotorRaiseEncoder.get() < encoderUpDownDistance)) { // ToDo: May have to go further
      hatchMotorRaiseController.set(0.3);// ToDo: May have to increase the voltage
      SmartDashboard.putNumber("HatchMotorRaiseEncoder:", hatchMotorRaiseEncoder.get());
    } else {
      hatchMotorRaiseController.set(0.05);
      hatchMotorRaiseEncoder.reset();
    }
    // 250 is half way
    // while(hatchTurnMotorEncoder.get() > -150){
    // hatchTurnMotorController.set(-0.5);
    // }
    // hatchTurnMotorController.set(0);
  }

  public void moveDown() {
    //hatchMotorRaiseEncoder.reset();
    if((hatchMotorRaiseEncoder.get() > (-1 * encoderUpDownDistance))) {
      hatchMotorRaiseController.set(-0.2);
      SmartDashboard.putNumber("HatchMotorRaiseEncoder:", hatchMotorRaiseEncoder.get());
    }else{
      hatchMotorRaiseController.set(0);
    hatchMotorRaiseEncoder.reset();
    }// hatchTurnMotorEncoder.reset();
    // while(hatchTurnMotorEncoder.get() < 103){
    // hatchTurnMotorController.set(0.5);
    // }
    // hatchTurnMotorController.set(0);
  }
  // public void testMotorSpeed(double speed)
  // {
  // elevatorMotor.set(speed);
  // }
  // when button is pushed arm lowers because the arm was placed that way
  // if same button is pushed then return to the up original position
  // if same button is pushed while in action the arm stops
  // can only go to two points and no where else
  // takes the "% 2" of the number of times button pushed, if zero then do
  // nothing, if one then store value.
  // when robot starts zero no trun at start, if one then turn to original
  // position

  // TURNING MOTOR
  // hand is manually up in start position
  // counts number of times the turn button is pushed
  // hand turns 180 degrees when button pushed
  // takes the "% 2" of the number of times button pushed, if zero then do
  // nothing, if one then store value.
  // when robot starts zero no trun at start, if one then turn to original
  // position

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void startPosition() {
    hatchMotorRaiseController.set(0.05);
  }

  public boolean reachedTurn()
  {
    if(hatchTurnMotorEncoder.get() >= encoderRotate)
    {
      return true;
    }
    return false;
  }
  public boolean reachedDown()
  {
    if(hatchMotorRaiseEncoder.get() >= encoderUpDownDistance)
    {
      return true;
    }
    return false;
  }
}
