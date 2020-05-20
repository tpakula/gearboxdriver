package com.tpakula.gearbox.driver

import spock.lang.Specification
import spock.lang.Unroll

class GearTest extends Specification {

    @Unroll
    def "should fail to create invalid gear: #gear"() {
        when:
        Gear.create(gear)
        then:
        thrown(IllegalArgumentException)
        where:
        gear << [0, -1]
    }

    @Unroll
    def "should create next gear"() {
        expect:
        new Gear(currentGear).next() == new Gear(nextGear)
        where:
        currentGear || nextGear
        5           || 6
        1           || 2
        3           || 4
    }

    @Unroll
    def "should create previous gear"() {
        expect:
        new Gear(currentGear).previous() == new Gear(previousGear)
        where:
        currentGear || previousGear
        6           || 5
        3           || 2
        1           || 0
    }

    def "should compare greater gear"() {
        given:
        def lowerGear = new Gear(3)
        def higherGear = new Gear(5)
        expect:
        !lowerGear.greaterThan(higherGear)
        higherGear.greaterThan(lowerGear)
        !lowerGear.greaterThan(lowerGear)
        !higherGear.greaterThan(higherGear)
    }

    def "should compare lower gear"() {
        given:
        def lowerGear = new Gear(3)
        def higherGear = new Gear(5)
        expect:
        lowerGear.lowerThan(higherGear)
        !higherGear.lowerThan(lowerGear)
        !lowerGear.lowerThan(lowerGear)
        !higherGear.lowerThan(higherGear)
    }
}
