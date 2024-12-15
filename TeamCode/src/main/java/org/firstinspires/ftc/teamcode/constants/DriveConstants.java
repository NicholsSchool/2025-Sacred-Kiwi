package org.firstinspires.ftc.teamcode.constants;

public interface DriveConstants {
    double LEFT_DRIVE_OFFSET = Math.PI / 6.0;
    double BACK_DRIVE_OFFSET = 1.5 * Math.PI;
    double RIGHT_DRIVE_OFFSET = 5.0 * Math.PI / 6.0;
    /** Dead wheel diameter in inches */
    double DEAD_WHEEL_DIAMETER = 2.5;
    /** Thru Bore Encoder ticks per revolution */
    int THRU_BORE_TICKS_PER_REV = 8192;
    /** Inches per tick of a dead wheel */
    double INCHES_PER_TICK = DEAD_WHEEL_DIAMETER * Math.PI / THRU_BORE_TICKS_PER_REV;

    /** Horizontal Correction coefficient */
    double STRAFE_ODOMETRY_CORRECTION = 0.553336722097;

    /** Forward Correction coefficient */
    double FORWARD_ODOMETRY_CORRECTION = 0.942379475317;
}
