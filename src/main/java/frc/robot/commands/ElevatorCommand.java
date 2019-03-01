/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class ElevatorCommand extends Command {
  int level = 1;
  private boolean toggleA = true;
  private boolean toggleB = true;
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
    if(toggleA && OI.copilotController.isYButtonPressed())
    {
      toggleA = false;
      if(level ==1)
      {
       level = 2;
        Robot.elevatorSubsystem.goToLevel2();
      }
      else if (level == 2)
      {
        level = 3;
        Robot.elevatorSubsystem.goToLevel3();
      }
    }
    else if(!OI.pilotController.isYButtonPressed())
    {
      toggleA = true;
    }
    

    if(toggleB && OI.copilotController.isBButtonPressed())
    {
      toggleB = false;
      if(level == 3)
      {
       level = 2;
        Robot.elevatorSubsystem.goToLevel2();
      }
      else if (level == 2)
      {
        level = 1;
        Robot.elevatorSubsystem.goToLevel1();
      }
    }
    else if(!OI.pilotController.isBButtonPressed())
    {
      toggleB = true;
    }
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
