package com.tpakula.gearbox.driver

import spock.lang.Specification
import spock.lang.Unroll

class GearCalculatorTest extends Specification {

    @Unroll
    def "should return proper gear"() {
        given:
        def MIN_RPM = RPM.create(1000)
        def MAX_RPM = RPM.create(4000)

        def GEAR_RANGE = GearRange.create(1, 5)

        def calculator = new GearCalculator(MIN_RPM, MAX_RPM, GEAR_RANGE)
        expect:
        expectedGear == calculator.calulateGear(currentRPM, currentGear)

        where:
        currentRPM       | currentGear    || expectedGear
        RPM.create(2000) | Gear.create(3) || Gear.create(3)
        RPM.create(5000) | Gear.create(3) || Gear.create(4)
        RPM.create(5000) | Gear.create(5) || Gear.create(5)
        RPM.create(500)  | Gear.create(3) || Gear.create(2)
        RPM.create(500)  | Gear.create(1) || Gear.create(1)
    }
}
