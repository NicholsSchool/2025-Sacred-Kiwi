package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.controller.Controller;
import org.firstinspires.ftc.teamcode.math_utils.Angles;
import org.firstinspires.ftc.teamcode.math_utils.Point;
import org.firstinspires.ftc.teamcode.math_utils.RobotPose;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.LimelightSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ReduxGyro;

import java.util.Optional;

/**
 * Teleop for the Drivetrain
 */
@TeleOp(name="Drivetrain Testing", group="Testing")
public class DriveTele extends OpMode{
    private Drivetrain drivetrain;
    private Controller controller;
    private ReduxGyro gyro;
   // private ElapsedTime loopTime;

    private LimelightSubsystem limelight;

    /**
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        controller = new Controller(gamepad1);
        drivetrain = new Drivetrain(hardwareMap, new RobotPose(0, 0, 0));
        limelight = new LimelightSubsystem(hardwareMap);
        gyro = new ReduxGyro( hardwareMap );
    }
    /**
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        controller.update();
        drivetrain.update();

        drivetrain.drive(controller.leftStick.toVector(), controller.rightStick.x.value());


        telemetry.addData("pose", drivetrain.getPose());


        telemetry.addData("Yaw", drivetrain.otos.getPosition().h);
        limelight.updateWithPose(gyro.getAngle());

        Optional<Point> robotPose = limelight.getRobotPose();
        telemetry.addData("Limelight x", robotPose.isPresent() ? robotPose.get().x : "No AT");
        telemetry.addData("Limelight y", robotPose.isPresent() ? robotPose.get().y : "No AT");
        telemetry.addData("Redux Gyro out", gyro.getAngle());
        telemetry.update();
    }

    /**
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}