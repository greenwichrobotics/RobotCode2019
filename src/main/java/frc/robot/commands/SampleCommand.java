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

public class SampleCommand extends Command {

  private boolean toggleA = true;
  private boolean toggleB = true;
  private boolean isDown = true;

  public SampleCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.sampleSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(toggleA && OI.pilotController.isAButtonPressed())
    {
      toggleA = false;
      if(isDown == true)
      {
        isDown = false;
        Robot.sampleSubsystem.turnClockwise();
      }
      else if (isDown == false)
      {
        isDown = true;
        Robot.sampleSubsystem.turnCounterclockwise();
      }
    }
    else if(!OI.pilotController.isAButtonPressed())
    {
      toggleA = true;
    }

    if(toggleB && OI.pilotController.isBButtonPressed())
    {
      toggleB = false;
      Robot.sampleSubsystem.testMotorSpeed(OI.getSpeed());
    }
    else if(!OI.pilotController.isBButtonPressed())
    {
      toggleB = true;
      Robot.sampleSubsystem.testMotorSpeed(0);
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
