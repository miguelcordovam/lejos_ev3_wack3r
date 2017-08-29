package com.miguel.example;

import lejos.hardware.Sound;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lejos.utility.Timer;
import lejos.utility.TimerListener;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        EV3LargeRegulatedMotor MOTOR_A = new EV3LargeRegulatedMotor(MotorPort.A);
        EV3MediumRegulatedMotor MOTOR_B = new EV3MediumRegulatedMotor(MotorPort.B);
        EV3LargeRegulatedMotor MOTOR_C = new EV3LargeRegulatedMotor(MotorPort.C);

        BaseRegulatedMotor[] motors = new BaseRegulatedMotor[3];

        motors[0] = MOTOR_A;
        motors[1] = MOTOR_B;
        motors[2] = MOTOR_C;

        for (int i = 0 ; i < 10 ; i++) {
            Random random = new Random();
            int randomMotor = random.nextInt(3);

            BaseRegulatedMotor motor = motors[randomMotor];

            if (motor instanceof  EV3MediumRegulatedMotor) {
                motor.rotate(70);
                motor.rotate(-70);
            } else {
                motor.rotate(30);
                motor.rotate(-30);
            }

            Delay.msDelay(1000);
        }

        MOTOR_A.close();
        MOTOR_B.close();
        MOTOR_C.close();

    }
}