package com.tpakula.gearbox.driver;

import com.vendor.externalsystems.Gearbox;

public class GearboxAdapter {

    private final Gearbox gearbox;

    public GearboxAdapter(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public void setGear(Gear gear) {
        gearbox.setCurrentGear(gear.gear);
    }

    public Gear getCurrentGear() {
        Integer currentGear = (Integer) gearbox.getCurrentGear();
        return Gear.create(currentGear);
    }
}
