/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ClimberCommand extends Command {
  private boolean Level1 = true;
  private boolean Level2 = false;
  private boolean Level3 = false;
  private boolean hotWheelsForward = false;
  private boolean hotWheelsBackward = false;

  public ClimberCommand() {
    requires(Robot.climberSubsystem);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis); 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override

  protected void execute() {
    // if(Level1 && OI.pilotController.isYButtonPressed()) // Descend from 6pt Platform
    // {
    //   Robot.climberSubsystem.ClimberLevel2(2);
    //   Robot.climberSubsystem.hotWheelsBackward();
    //   Robot.climberSubsystem.ClimberLevel2(1);
    //   Robot.climberSubsystem.hotWheelsBackward();
    //   Robot.climberSubsystem.ClimberLevel1(3);
    // }
    if(Level1 && OI.pilotController.isXButtonPressed())
    {
        Robot.climberSubsystem.testUp();
    }
    if(Level1 && OI.pilotController.isAButtonPressed())
    {
      Robot.climberSubsystem.testDown();
    }
    // if(Level1 && OI.pilotController.isXButtonPressed()) // Climb to 12pt Platform
    // {
    //   Robot.climberSubsystem.ClimberLevel3(3);
    //   Robot.climberSubsystem.hotWheelsForward();
    //   Robot.climberSubsystem.ClimberLevel1(1);
    //   Robot.climberSubsystem.hotWheelsForward();
    //   Robot.climberSubsystem.ClimberLevel1(2);
    // }

    // if(Level1 && OI.pilotController.isAButtonPressed()) // Climb to 6pt Platform
    // {
    //   Robot.climberSubsystem.ClimberLevel2(3);
    //   Robot.climberSubsystem.hotWheelsForward();
    //   Robot.climberSubsystem.ClimberLevel1(1);
    //   Robot.climberSubsystem.hotWheelsForward();
    //   Robot.climberSubsystem.ClimberLevel1(2);
    // }

    // if(Level2 && OI.pilotController.isXButtonPressed())
    // {
    //   Level1 = true;
    //   Level2 = false;
    //   Level3 = false;
    //   Robot.climberSubsystem.ClimberLevel1(1);
    //   // Robot.climberSubsystem.ClimberLevel1(3);
    //}

    // if(OI.pilotController.isRBButtonPressed()) //Makes hotwheels go forwards on left bumper button press
    // {
    //   hotWheelsForward = true;
    //   hotWheelsBackward = false;
    //   Robot.climberSubsystem.hotWheelsForward();
    // }

    // if(OI.pilotController.isLBButtonPressed()) //Makes hotwheels go backwards on right bumper button press
    // {
    //   hotWheelsForward = false;
    //   hotWheelsBackward = true;
    //   Robot.climberSubsystem.hotWheelsBackward();
    // }
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
 *    
 */