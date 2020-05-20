package com.tpakula.gearbox.driver;

public class RPM implements Comparable<RPM> {
    private long rpm;

    RPM(long rpm) {
        this.rpm = rpm;
    }

    boolean greaterThan(RPM other) {
        return other.compareTo(this) > 0;
    }

    boolean lowerThan(RPM other) {
        return compareTo(other) > 0;
    }

    @Override
    public int compareTo(RPM other) {
        return Long.compare(rpm, other.rpm);
    }

    public static RPM create(long rpm) {
        if (rpm < 0) {
            throw new IllegalArgumentException("Rpm should be positive");
        }
        return new RPM(rpm);
    }
}
