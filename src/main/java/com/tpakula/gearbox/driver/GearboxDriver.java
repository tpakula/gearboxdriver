package com.tpakula.gearbox.driver;

import com.vendor.externalsystems.ExternalSystems;

public class GearboxDriver {
    enum GearboxState {
        NEUTRAL,
        PARK,
        REVERSE,
        DRIVE;
    }

    enum DriveMode {
        ECO,
        COMFORT,
        SPORT
    }

    private final GearboxAdapter gearbox;
    private final GearCalculatorProvider calculatorProvider;
    private GearboxState state = GearboxState.PARK;
    private ExternalSystems externalSystems;
    private DriveMode driveMode = DriveMode.COMFORT;


    public GearboxDriver(GearboxAdapter gearbox, GearCalculatorProvider calculatorProvider) {
        this.gearbox = gearbox;
        this.calculatorProvider = calculatorProvider;
    }

    private GearCalculator getGearCalculator() {
        switch (driveMode) {
            case ECO:
                return calculatorProvider.getEcoGearCalculator();
            case COMFORT:
                return calculatorProvider.getComfortGearCalculator();
            case SPORT:
                return calculatorProvider.getSportGearCalculator();
            default:
                throw new IllegalStateException("Unknown drive mode");
        }
    }


    public void updateGear() {
        if (state == GearboxState.DRIVE) {
            RPM currentRpm = getRpm();
            Gear currentGear = gearbox.getCurrentGear();

            Gear gear = getGearCalculator().calulateGear(currentRpm, currentGear);

            gearbox.setGear(gear);
        }
    }

    private RPM getRpm() {
        double currentRpm = externalSystems.getCurrentRpm();
        return RPM.create(Math.round(currentRpm));
    }
}
