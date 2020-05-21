package com.tpakula.gearbox.driver;

public class GearCalculatorProvider {
    private static final int MIN_GEAR = 1;
    private static final int MAX_GEAR = 8;

    private Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d, 5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};

    GearCalculator getComfortGearCalculator() {
        return createGearCalculator(2, 4);
    }

    GearCalculator getEcoGearCalculator() {
        return createGearCalculator(1, 0);
    }

    GearCalculator getSportGearCalculator() {
        return createGearCalculator(6, 8);
    }

    private GearCalculator createGearCalculator(int minRpmIndex, int maxRpmIndex) {
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
