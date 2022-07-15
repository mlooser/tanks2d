package com.mlooser.gameengine

import spock.lang.*

class SpockSimpleTest  extends Specification{
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }
}
