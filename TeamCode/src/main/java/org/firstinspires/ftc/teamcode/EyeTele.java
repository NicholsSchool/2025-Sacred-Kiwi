package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.EyeBalls;
import org.firstinspires.ftc.teamcode.subsystems.EyeBalls.Eye;

@TeleOp(name = "EyeTeleop", group = "Eyes")
public class EyeTele extends OpMode {

    private EyeBalls balls;

    @Override
    public void init() {

        balls = new EyeBalls(hardwareMap);

    }

    @Override
    public void loop() {



        balls.setEyeBallX(0.5 + (0.2 * -gamepad1.left_stick_x));
        balls.setEyeBallY(0.5 + (0.2 * -gamepad1.left_stick_y));

        balls.setEyeLidState(Eye.LEFT, !gamepad1.left_bumper);
        balls.setEyeLidState(Eye.RIGHT, !gamepad1.right_bumper);

        telemetry.addData("Positions", balls.getServoPositions());
        telemetry.update();

    }
}
