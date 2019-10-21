/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import frc.robot.commands.ClimberCommand;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.commands.HatchClawCommand;
//import frc.robot.commands.SampleCommand;
import frc.robot.subsystems.DriveTrainSubSystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.UltrasonicSubSystem;
//import frc.robot.subsystems.SampleSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.HatchClawSubsystem;
import frc.robot.commands.ElevatorCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  public static final HatchClawSubsystem hatchClawSubsystem = new HatchClawSubsystem();
  public static final UltrasonicSubSystem ultrasonicSubSystem = new UltrasonicSubSystem();
  public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  public static final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  //public static final ClimberCommand climberCommand = new ClimberCommand();
  public static final DriveTrainSubSystem driveTrainSubSystem = new DriveTrainSubSystem();
   //public static final DriveTrainCommand driveTrainCommand = new DriveTrainCommand();
 
  public static OI m_oi;

 
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  @Override
  public void robotInit() {
       OI.init();
       CameraServer.getInstance().startAutomaticCapture();
       //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
       // chooser.addOption("My Auto", new MyAutoCommand());
  }

  @Override
  public void autonomousInit() {
    // m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
    // }
  }

  @Override
  public void autonomousPeriodic() {
   // Scheduler.getInstance().run();
   teleopPeriodic();
  }

  @Override
  public void teleopInit() {
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }
    
    Scheduler.getInstance().add(new DriveTrainCommand());
  //  Scheduler.getInstance().add(new ClimberCommand());
    Scheduler.getInstance().add(new HatchClawCommand());
    Scheduler.getInstance().add(new ElevatorCommand());
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
