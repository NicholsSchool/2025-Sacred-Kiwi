package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.math_utils.NewRobotPose;

@TeleOp(name = "Localization Testing", group = "Testing")
public class LocalizationTesting extends OpMode {

    NewRobotPose robotPose;

    @Override
    public void init() {

        robotPose = new NewRobotPose(hardwareMap, new Pose2D(DistanceUnit.METER, 0, 0, AngleUnit.DEGREES, 0));

    }

    @Override
    public void loop() {

        telemetry.addData("transformed odom", robotPose.debugTransform());
        telemetry.update();

    }
}
