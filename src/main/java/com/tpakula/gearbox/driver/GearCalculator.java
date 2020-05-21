package com.tpakula.gearbox.driver;

public class GearCalculator {
    private final GearRange gearRange;
    private final RPMRange optimalRange;

    public GearCalculator(RPMRange optimalRange, GearRange gearRange) {
        this.optimalRange = optimalRange;
        this.gearRange = gearRange;
    }


    public Gear calulateGear(RPM currentRPM, Gear currentGear) {
        if (currentRPM.isBelow(optimalRange)) {
            return gearRange.previous(currentGear);
        }

        if (currentRPM.isAbove(optimalRange)) {
            return gearRange.next(currentGear);
        }
        return currentGear;
    }

}
