/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SampleSubsystem extends Subsystem {
  VictorSP hatchMotorController;
  Encoder hatchMotorEncoder;


  public SampleSubsystem(){
    hatchMotorController = new VictorSP(RobotMap.hatchMotor);
    hatchMotorEncoder = new Encoder(RobotMap.armEncoderA, RobotMap.armEncoderB);
  }

  public void turnClockwise() {
    hatchMotorEncoder.reset();
    //250 is half way
    while(hatchMotorEncoder.get() > -250){
    hatchMotorController.set(-0.5);
  }
  hatchMotorController.set(0);
  }

  public void turnCounterclockwise(){
    hatchMotorEncoder.reset();
    while(hatchMotorEncoder.get() < 250){
    hatchMotorController.set(0.5);
  }
  hatchMotorController.set(0);  
  }

  public void testMotorSpeed(double speed)
  {
      hatchMotorController.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
