package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.constants.BallConstants;

import java.util.Locale;

public class EyeBalls implements BallConstants {

    public ServoImplEx eyeBallX, eyeBallY, eyeLeftUpperLid, eyeLeftLowerLid, eyeRightUpperLid, eyeRightLowerLid;

    public EyeBalls(HardwareMap hwMap) {
        eyeBallX = hwMap.get(ServoImplEx.class, "eyeBallX");
        eyeBallY = hwMap.get(ServoImplEx.class, "eyeBallY");
        eyeLeftUpperLid = hwMap.get(ServoImplEx.class, "eyeLeftUpperLid");
        eyeLeftLowerLid = hwMap.get(ServoImplEx.class, "eyeLeftLowerLid");
        eyeRightUpperLid = hwMap.get(ServoImplEx.class, "eyeRightUpperLid");
        eyeRightLowerLid = hwMap.get(ServoImplEx.class, "eyeRightLowerLid");
    }

    public enum Eye {
        LEFT, RIGHT
    }

    public void setEyeBallX(double position) {
        eyeBallX.setPosition(position);
    }

    public void setEyeBallY(double position) {
        eyeBallY.setPosition(position);
    }

    private void setEyeLidsPosition(Eye eye, double lowerPosition, double upperPosition) {
        switch (eye) {
            case LEFT:
                eyeLeftLowerLid.setPosition(lowerPosition);
                eyeLeftUpperLid.setPosition(upperPosition);
                break;
            case RIGHT:
                eyeRightLowerLid.setPosition(lowerPosition);
                eyeRightUpperLid.setPosition(upperPosition);
                break;
                default:
                break;
        }
    }

    public void setEyeLidState(Eye eye, boolean open) {
        switch (eye) {
            case LEFT:
                eyeLeftUpperLid.setPosition(open ? LEFT_UPPER_OPEN : LEFT_UPPER_CLOSED);
                eyeLeftLowerLid.setPosition(open ? LEFT_LOWER_OPEN : LEFT_LOWER_CLOSED);
                break;
            case RIGHT:
                eyeRightUpperLid.setPosition(open ? RIGHT_UPPER_OPEN : RIGHT_UPPER_CLOSED);
                eyeRightLowerLid.setPosition(open ? RIGHT_LOWER_OPEN : RIGHT_LOWER_CLOSED);
        }
    }

    public String getServoPositions() {
        return String.format(Locale.US, "[%.3f, %.3f, %.3f, %.3f, %.3f, %.3f]",
                eyeBallX.getPosition(),
                eyeBallY.getPosition(),
                eyeLeftUpperLid.getPosition(),
                eyeLeftLowerLid.getPosition(),
                eyeRightUpperLid.getPosition(),
                eyeRightLowerLid.getPosition()
                );
    }

}
