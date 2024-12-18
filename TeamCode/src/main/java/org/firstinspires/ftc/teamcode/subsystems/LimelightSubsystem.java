package subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import java.util.Optional;

public class LimelightSubsystem extends SubsystemBase {
    
    private Limelight3A limelight3A;

    /**
     * Constructs a limelight subsytem.
     */
    public LimelightSubsystem( final Limelight3A limelight3A )
    {
        this.limelight3A = limelight3A;
        limelight3A.setPollRateHz(50);
        limelight3A.start();
    }

    /**
     * Updates the limelight's pose with the robot yaw. This is needed for MT2 stable detection. REQUIRED.
     * @param yaw the yaw aligned with the field map
     */
    public void updateWithPose( double yaw )
    {
        limelight3A.updateRobotOrientation(yaw);
    }


    /**
     * Returns the estimated robot pose within LL's field coordinates. 
     * More accurately, returns the nearest LL result pose using MT2 detection, requiring an accurate robot yaw update.
     * Will return an empty optional if the LL is not on, connected, no AT's are in view, or the nearest AT is > 2m away.
     * 
     * @return an Optional of the Point representing the estimated robot pose, in LL field coorinates. 
     *  Empty optional of no detected or the result is beyond 2m.
     */
    public Optional<Point> getRobotPose()
    {
        LLResult result = limelight3A.getLatestResult();
        if( !result.isValid() || result.getBotposeAvgDist() > 2 ) // 2 meters max dist
            return Optional.empty();
       return Optional.of(new Point(result.getBotpose_MT2().getPosition().x, result.getBotpose_MT2().getPosition().y));
    }


}
