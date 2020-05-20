package com.tpakula.gearbox.driver;

public class GearRange {
    private final Gear minGear;
    private final Gear maxGear;


    GearRange(Gear minGear, Gear maxGear) {
        this.minGear = minGear;
        this.maxGear = maxGear;
    }

    Gear next(Gear currentGear) {
        Gear nextGear = currentGear.next();
        return trim(nextGear);
    }

    private Gear trim(Gear gear) {
        if (gear.greaterThan(maxGear)) {
            return maxGear;
        }
        if (gear.lowerThan(minGear)) {
            return minGear;
        }
        return gear;
    }

    public Gear previous(Gear currentGear) {
        Gear previous = currentGear.previous();
        return trim(previous);
    }

    public static GearRange create(int minGear, int maxGear) {
        if (minGear > maxGear) {
            throw new IllegalArgumentException("Invalid gear range");
        }
        return new GearRange(Gear.create(minGear), Gear.create(maxGear));

    }
}
