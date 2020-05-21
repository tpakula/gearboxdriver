package com.tpakula.gearbox.driver;

import com.vendor.externalsystems.ExternalSystems;

public class GearboxDriver {
    private Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d, 5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};

    private static final int MIN_GEAR = 1;
    private static final int MAX_GEAR = 8;


    enum GearboxState {
        NEUTRAL,
        PARK,
        REVERSE,
        DRIVE;

    }

    private final GearboxAdapter gearbox;
    private final GearCalculator gearCalculator;
    private GearboxState state = GearboxState.PARK;
    private ExternalSystems externalSystems;


    public GearboxDriver(GearboxAdapter gearbox, GearCalculator gearCalculator) {
        this.gearbox = gearbox;
        this.gearCalculator = gearCalculator;
    }


    public void updateGear() {
        if (state == GearboxState.DRIVE) {
            RPM currentRpm = getRpm();
            Gear currentGear = gearbox.getCurrentGear();

            Gear gear = gearCalculator.calulateGear(currentRpm, currentGear);

            gearbox.setGear(gear);
        }
    }

    private RPM getRpm() {
        double currentRpm = externalSystems.getCurrentRpm();
        return RPM.create(Math.round(currentRpm));
    }

    private GearCalculator createEcoGearCalculator(int minRpmIndex, int maxRpmIndex) {
        Double minRpmDouble = (Double) characteristics[minRpmIndex];
        Double maxRpmDouble = (Double) characteristics[maxRpmIndex];

        long minRpmLong = Math.round(minRpmDouble);
        long maxRpmLong = Math.round(maxRpmDouble);

        RPM minRpm = RPM.create(minRpmLong);
        RPM maxRpm = RPM.create(maxRpmLong);

        GearRange gearRange = GearRange.create(MIN_GEAR, MAX_GEAR);


        RPMRange rpmRange = RPMRange.create(minRpm, maxRpm);

        return new GearCalculator(rpmRange, gearRange);
    }
}
