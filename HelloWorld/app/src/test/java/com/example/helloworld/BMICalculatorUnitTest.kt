package com.example.helloworld

import org.junit.Assert.*
import org.junit.Test

class BMICalculatorUnitTest {
    @Test
    fun calculate_isCorrect() {
        val calc: BMICalculator = BMICalculator()
        var res: Double = calc.calculate(50.0, 1.6)
        assertEquals(19.5, res, 0.1)

        res = calc.calculate(60.0, 1.65)
        assertEquals(22.0, res, 0.1)
    }
}
