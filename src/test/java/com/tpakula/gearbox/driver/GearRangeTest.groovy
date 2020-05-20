package com.tpakula.gearbox.driver

import spock.lang.Specification
import spock.lang.Unroll

class GearRangeTest extends Specification {
    @Unroll
    def "should fail to create invalid range"() {
        when:
        GearRange.create(minGear, maxGear)
        then:
        thrown(IllegalArgumentException)

        where:
        minGear | maxGear
        -1      | 5
        5       | 1
    }

    @Unroll
    def "should return next gear"() {
        given:
        def range1to3 = new GearRange(new Gear(1), new Gear(3))

        expect:
        new Gear(nextGear) == range1to3.next(new Gear(currentGear))

        where:
        currentGear || nextGear
        1           || 2
        2           || 3
        3           || 3
    }

    @Unroll
    def "should return previous gear"() {
        given:
        def range1to3 = new GearRange(new Gear(1), new Gear(3))

        expect:
        new Gear(nextGear) == range1to3.previous(new Gear(currentGear))

        where:
        currentGear || nextGear
        3           || 2
        2           || 1
        1           || 1
    }
}
