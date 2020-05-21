package com.tpakula.gearbox.driver;

import java.util.Objects;

public class Gear implements Comparable<Gear> {
    final int gear;

    Gear(int gear) {
        this.gear = gear;
    }

    public int compareTo(Gear other) {
        return Integer.compare(gear, other.gear);
    }

    Gear next() {
        return new Gear(gear + 1);
    }

    Gear previous() {
        return new Gear(gear - 1);
    }

    boolean greaterThan(Gear other) {
        return compareTo(other) > 0;
    }

    boolean lowerThan(Gear other) {
        return other.compareTo(this) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear1 = (Gear) o;
        return gear == gear1.gear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gear);
    }

    @Override
    public String toString() {
        return "Gear{" +
                "gear=" + gear +
                '}';
    }

    public static Gear create(int gear) {
        if (gear <= 0) {
            throw new IllegalArgumentException("Invalid gear");
        }
        return new Gear(gear);
    }
}
