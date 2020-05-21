package com.tpakula.gearbox.driver;

public class RPMRange {
    final RPM min;
    final RPM max;

    private RPMRange(RPM min, RPM max) {
        this.min = min;
        this.max = max;
    }

    public static RPMRange create(RPM min, RPM max) {
        if (min.greaterThan(max)) {
            throw new IllegalArgumentException("min should be lower than max");
        }
        return new RPMRange(min, max);
    }
}
