package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ReduxGyro {
    private final AnalogInput reduxGyro;
    private final double zeroPoint;

    public ReduxGyro(HardwareMap hwmap)
    {
        reduxGyro = hwmap.get(AnalogInput.class, "reduxGyro");
        zeroPoint = reduxGyro.getVoltage();
    }

    public double getAngle()
    {
        return ( reduxGyro.getVoltage() - zeroPoint ) * 360.0 / 3.3;
    }

    public double getZeroPoint()
    {
        return zeroPoint;
    }
}
