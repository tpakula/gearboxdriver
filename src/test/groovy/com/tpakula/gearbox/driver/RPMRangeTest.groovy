package com.tpakula.gearbox.driver

import spock.lang.Specification

class RPMRangeTest extends Specification {

    def "should fail to create invalid RPMRange"() {
        given:
        def rpm1k = RPM.create(1000);
        def rpm20k = RPM.create(20000);
        when: "max is higher than min"
        RPMRange.create(rpm20k, rpm1k)
        then: "exception is thrown"
        thrown(IllegalArgumentException)

        when: "min is lower than max rpm"
        def range = RPMRange.create(rpm1k, rpm20k)
        then: "range is created"
        range != null
    }
}
