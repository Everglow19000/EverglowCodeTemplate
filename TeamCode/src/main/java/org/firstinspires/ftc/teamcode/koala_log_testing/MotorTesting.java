package org.firstinspires.ftc.teamcode.koala_log_testing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.json.JSONException;
import org.json.JSONObject;

import Ori.Coval.Logging.AutoLog;

@AutoLog
public class MotorTesting {
    private DcMotorEx motor;

    public int motorPosition;

    public MotorTesting(HardwareMap hardwareMap, boolean isReversed, String name) {
        motor = hardwareMap.get(DcMotorEx.class, name);
        motor.setTargetPosition(0);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setDirection(isReversed ? DcMotorSimple.Direction.REVERSE : DcMotorSimple.Direction.FORWARD);
    }

    public void setTargetPosition(int pos) {
        motor.setTargetPosition(pos);
    }

    public void setPower(double power) {
        motor.setPower(power);
    }

    public String getMotorStats() throws JSONException {
//        JSONObject j = new JSONObject();
//        j.accumulate("current_amps: ", motor.getCurrent(CurrentUnit.AMPS));
//        return j.toString();
        StringBuilder out = new StringBuilder();
        out.append("current: ");
        out.append(motor.getCurrent(CurrentUnit.AMPS));
        out.append(" | position: ");
        out.append(motor.getCurrentPosition());
        out.append(" | targetPosition: ");
        out.append(motor.getTargetPosition());
        return out.toString();
    }

    public void update() {
        motorPosition = motor.getCurrentPosition();
    }
}
