/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------*/
/* JavaDoc
/* C:\Users\PiHi Samurai 1076\sunspotfrcsdk\doc
/*----------------------------------------------------------------------------*/

package org.pihisamurai;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.communication.FRCCommonControlData;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BootcampRobot extends SimpleRobot {
    
    FRCCommonControlData controlData = new FRCCommonControlData();
        
    Gamepad gamepad = new Gamepad(1);
    
    //Double Check these every time robot re-wired
    Jaguar motorFrontRight = new Jaguar(1);
    Jaguar motorFrontLeft = new Jaguar(4);
    Jaguar motorBackRight = new Jaguar(2);
    Jaguar motorBackLeft = new Jaguar(3);
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous()
    {
        System.out.println("Autonomous Mode");
        
        
        motorFrontRight.set(-0.3);
        motorFrontLeft.set(0.3);
        motorBackRight.set(-0.3);
        motorBackLeft.set(0.3);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        motorFrontRight.set(0);
        motorFrontLeft.set(0);
        motorBackRight.set(0);
        motorBackLeft.set(0);
        
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl()
    {   
        System.out.println("Operator Mode");

        while(true)
        {
            motorFrontRight.set(-gamepad.getRightY());
            motorFrontLeft.set(gamepad.getLeftY());
            motorBackRight.set(-gamepad.getRightY());
            motorBackLeft.set(gamepad.getLeftY());
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test()
    {
        motorFrontRight.set(0);
        motorFrontLeft.set(0);
        motorBackRight.set(0);
        motorBackLeft.set(0);
        
        System.out.println("Test Mode");
        
        while(true)
        {
            while(!gamepad.getButtonA())
            {
                try {
                    Thread.sleep(10);
                    //Wait till user presses button
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
          //Display Something Cool
          System.out.println("  _____ _ _    _ _  _____                                 _ \n |  __ (_) |  | (_)/ ____|                               (_)\n | |__) || |__| |_| (___   __ _ _ __ ___  _   _ _ __ __ _ _ \n |  ___/ |  __  | |\\___ \\ / _` | '_ ` _ \\| | | | '__/ _` | |\n | |   | | |  | | |____) | (_| | | | | | | |_| | | | (_| | |\n |_|   |_|_|  |_|_|_____/ \\__,_|_| |_| |_|\\__,_|_|  \\__,_|_|");

            while(gamepad.getButtonA())
            {
                try {
                    Thread.sleep(10);
                    //Wait till user unpresses button 
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }
}
