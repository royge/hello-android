package com.example.helloworld

class BMICalculator() {
    fun calculate(weight: Double, height: Double): Double {
        return weight / ( height * height )
    }
}