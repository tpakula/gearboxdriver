package com.tpakula.gearbox.driver

import spock.lang.Specification

class RPMTest extends Specification {

    def "should not create invalid RPM"() {
        when:
        RPM.create(-1)
        then:
        thrown(IllegalArgumentException)
    }

    def "should compare lowerRpm"() {
        given:
        def lowerRpm = RPM.create(1000)
        def greaterRpm = RPM.create(2000)

        expect:
        lowerRpm.lowerThan(greaterRpm)
        !greaterRpm.lowerThan(lowerRpm)
    }

    def "should compare greaterRpm"() {
        given:
        def lowerRpm = RPM.create(1000)
        def greaterRpm = RPM.create(2000)

        expect:
        greaterRpm.greaterThan(lowerRpm)
        !lowerRpm.greaterThan(greaterRpm)
    }
}
