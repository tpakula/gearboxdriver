package com.tpakula.gearbox.driver;

public class Gear implements Comparable<Gear> {

    private int gear;

    Gear(int gear) {
        this.gear = gear;
    }

    public static Gear create(int gear) {
        if (gear < 0) {
            throw new IllegalArgumentException("Invalid gear");
        }
        return new Gear(gear);
    }

    public int compareTo(Gear other) {
        return Integer.compare(gear, other.gear);
    }
}
