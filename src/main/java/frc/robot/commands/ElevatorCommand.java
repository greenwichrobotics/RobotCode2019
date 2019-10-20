/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.OI;

public class ElevatorCommand extends Command {
  int level = 1;
  private boolean toggleY = true;
  private boolean toggleX = true;
  public ElevatorCommand() {
   requires(Robot.elevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(toggleY && OI.copilotController.isYButtonPressed())
    {
      toggleY = false;
      // if(level ==0)
      // {
      // Robot.elevatorSubsystem.goToLevel1();
      //  level = 1;
        
      // }
      // else 
      if (level ==1)
      {
        Robot.elevatorSubsystem.goToLevel2();
        level = 2;
      }
      else if (level == 2)
      {
        Robot.elevatorSubsystem.goToLevel3();
        level = 3;
      }
    }
    else if(!OI.pilotController.isYButtonPressed())
    {
      toggleY = true;
    }
    

    if(toggleX && OI.copilotController.isXButtonPressed())
    {
      toggleX = false;
      if(level == 3)
      {
        Robot.elevatorSubsystem.goToLevel2();
        level = 2;
      }
      else if (level == 2)
      {
        Robot.elevatorSubsystem.goToLevel1();
        level = 1;
      }
    }
    else if(!OI.pilotController.isXButtonPressed())
    {
      toggleX = true;
    }
    SmartDashboard.putNumber("Elevator:", Robot.elevatorSubsystem.getElevatorEncoder());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
