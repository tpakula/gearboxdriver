package com.tpakula.gearbox.driver;

public class GearCalculator {
    private final RPM minRpm;
    private final RPM maxRpm;
    private final GearRange gearRange;

    public GearCalculator(RPM minRpm, RPM maxRpm, GearRange gearRange) {
        this.minRpm = minRpm;
        this.maxRpm = maxRpm;
        this.gearRange = gearRange;
    }


    public Gear calulateGear(RPM currentRPM, Gear currentGear) {
        if (currentRPM.lowerThan(minRpm)) {
            return gearRange.previous(currentGear);
        }

        if (currentRPM.greaterThan(maxRpm)) {
            return gearRange.next(currentGear);
        }
        return currentGear;
    }

}
