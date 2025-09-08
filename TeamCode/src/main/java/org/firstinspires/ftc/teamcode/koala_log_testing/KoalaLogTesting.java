package org.firstinspires.ftc.teamcode.koala_log_testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Ori.Coval.Logging.AutoLogManager;
import Ori.Coval.Logging.Logger.KoalaLog;

@Config
@TeleOp(name="Koala Log Testing")
public class KoalaLogTesting extends LinearOpMode {
    MotorTestingAutoLogged motorTesting;

    public static int position = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        KoalaLog.setup(hardwareMap);

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        motorTesting = new MotorTestingAutoLogged(hardwareMap, false, "motor");

        waitForStart();

        motorTesting.setPower(0.5);

        while (opModeIsActive()) {
            AutoLogManager.periodic();

            motorTesting.setTargetPosition(position);

            motorTesting.update();
            
            telemetry.addLine(motorTesting.getMotorStats());
            telemetry.update();
        }
    }
}
