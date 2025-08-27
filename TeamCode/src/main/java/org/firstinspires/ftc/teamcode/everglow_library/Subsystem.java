package org.firstinspires.ftc.teamcode.everglow_library;

public interface Subsystem {
    // in robot class, all subsystems can be put in an array and update called on all
    public void update(int iterationCount);

    // can be called en mass for logging
    public String status();
}
