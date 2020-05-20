package com.tpakula.gearbox.driver;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "RPM{" +
                "rpm=" + rpm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPM rpm1 = (RPM) o;
        return rpm == rpm1.rpm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rpm);
    }
}
