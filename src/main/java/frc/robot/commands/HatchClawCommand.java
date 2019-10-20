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
//import frc.robot.subsystems.HatchClawSubsystem;

public class HatchClawCommand extends Command {
  private boolean toggleA = true; //For rotating left/right
  private boolean toggleRB = true; //For moving up
  private boolean toggleLB = true; //For moving down
 // private boolean isDown = false;
  //private boolean isTurnDown = true;
  public HatchClawCommand() {
    requires(Robot.hatchClawSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.hatchClawSubsystem.startPosition();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if((toggleA && OI.copilotController.isAButtonPressed()) || Robot.hatchClawSubsystem.reachedTurn())
    {
       toggleA = false;
      //  if(isTurnDown == true)
      //  {
      //    isTurnDown = false;
         Robot.hatchClawSubsystem.turnClockwise();
      //  }
      //  else if (isTurnDown == false)
      //  {
      //    isTurnDown = true;
      //    Robot.hatchClawSubsystem.turnCounterclockwise();
      //  }
     }
     else if(!OI.copilotController.isAButtonPressed())
     {
       toggleA = true;
     }
//////////////////////////////////
if((toggleRB && OI.copilotController.isRBButtonPressed()) || Robot.hatchClawSubsystem.reachedDown())
    {
       toggleRB = false;
      //  if(isDown == true)
      //  {
      //    isDown = false;
         Robot.hatchClawSubsystem.moveUp(); // HAVE TO FIX MOVE UP
       //}
      //  else if (isDown == false)
      //  {
      //    isDown = true;
      //    Robot.hatchClawSubsystem.moveDown();
      //  }
    }
    else if(!OI.copilotController.isRBButtonPressed())
    {
       toggleRB = true;
    }
 
  //////////////////////////////////
if((toggleLB && OI.copilotController.isLBButtonPressed()) || Robot.hatchClawSubsystem.reachedDown())
{
   toggleLB = false;
  //  if(isDown == false)
  //  {
  //    isDown = true;
     Robot.hatchClawSubsystem.moveDown();
   //}
  //  else if (isDown == false)
  //  {
  //    isDown = true;
  //    Robot.hatchClawSubsystem.moveDown();
  //  }
 }
 else if(!OI.copilotController.isLBButtonPressed())
 {
   toggleLB = true;
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
