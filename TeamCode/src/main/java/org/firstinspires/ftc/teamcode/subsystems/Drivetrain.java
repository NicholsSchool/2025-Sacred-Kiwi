package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.constants.DriveConstants;
import org.firstinspires.ftc.teamcode.math_utils.Angles;
import org.firstinspires.ftc.teamcode.math_utils.VectorMotionProfile;
import org.firstinspires.ftc.teamcode.math_utils.MotionProfile;
import org.firstinspires.ftc.teamcode.math_utils.Vector;
import org.firstinspires.ftc.teamcode.math_utils.RobotPose;
import org.firstinspires.ftc.teamcode.math_utils.SimpleFeedbackController;

import com.qualcomm.hardware.kauailabs.NavxMicroNavigationSensor;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Robot Drivetrain
 */
public class Drivetrain implements DriveConstants {
//    private final DcMotorEx leftDrive, rightDrive, backDrive,
//            frontOdometry, leftOdometry, rightOdometry;
    private int previousLeftPosition, previousRightPosition, previousFrontPosition;
    private double previousHeading, imuOffset, targetHeading;
    public final SparkFunOTOS otos;
    public RobotPose pose;

    /**
     * constructs a new drivetrain
     * @param hwMap
     * @param initialPose where the bot initially starts
     */
    public Drivetrain(HardwareMap hwMap, RobotPose initialPose) {
//        leftDrive = hwMap.get(DcMotorEx.class, "leftDrive");
//        rightDrive = hwMap.get(DcMotorEx.class, "rightDrive");
//        backDrive = hwMap.get(DcMotorEx.class, "backDrive");
//
//        frontOdometry = hwMap.get(DcMotorEx.class, "frontDead");
//        leftOdometry = hwMap.get(DcMotorEx.class, "leftDead");
//        rightOdometry = hwMap.get(DcMotorEx.class, "rightDead");
        otos = hwMap.get(SparkFunOTOS.class, "laser");

        otos.begin();
        otos.setAngularUnit(AngleUnit.DEGREES);
        otos.resetTracking();
        otos.calibrateImu();
        this.pose = initialPose;
    }

    /**
     * drives the bot generally, there is a separate one for profiled
     * @param driveInput vector for the bot to move at
     * @param turn turn power (how fast it spins)
     */
    public void drive(Vector driveInput, double turn) {
        double power = driveInput.magnitude();
        double angle = driveInput.angle();
//
//        leftDrive.setPower(turn + power * Math.cos(angle + LEFT_DRIVE_OFFSET - pose.angle));
//        rightDrive.setPower(turn + power * Math.cos(angle + RIGHT_DRIVE_OFFSET - pose.angle));
//        backDrive.setPower(turn + power * Math.cos(angle + BACK_DRIVE_OFFSET - pose.angle));
    }

    public void update() {
///*        int currentLeft = leftOdometry.getCurrentPosition();
//        int currentRight = rightOdometry.getCurrentPosition();
//        int currentFront = frontOdometry.getCurrentPosition();*/
//
//        double deltaX = (currentLeft - previousLeftPosition + currentRight - previousRightPosition) *
//                INCHES_PER_TICK * STRAFE_ODOMETRY_CORRECTION;
//        double deltaY = (currentFront - previousFrontPosition) *
//                INCHES_PER_TICK * FORWARD_ODOMETRY_CORRECTION;
//
//        pose.angle = imuOffset + getCorrectedYaw();
//
//        double averagedHeading = Angles.average(pose.angle, previousHeading);
//
//        pose.x += deltaX * Math.sin(averagedHeading) + deltaY * Math.cos(averagedHeading);
//        pose.y += -deltaX * Math.cos(averagedHeading) + deltaY * Math.sin(averagedHeading);
//
//        previousLeftPosition = currentLeft;
//        previousRightPosition = currentRight;
//        previousFrontPosition = currentFront;
//        previousHeading = pose.angle;
    }



    public void setPose(RobotPose pose){
        this.pose = pose;
    }

    public RobotPose getPose(){
        return pose;
    }


    private double getCorrectedYaw() {
        return Math.toRadians(-otos.getPosition().h);
    }

}