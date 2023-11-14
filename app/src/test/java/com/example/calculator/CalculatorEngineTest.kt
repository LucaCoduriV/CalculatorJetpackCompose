package com.example.calculator

import org.junit.Assert
import org.junit.Test

class CalculatorEngineTest{
    @Test
    fun addition_isCorrect() {
        val engine = CalculatorEngine()
        engine.addNumber(5.0)
        engine.addNumber(4.0)
        engine.addNumber(3.0)
        engine.addNumber(2.0)
        Assert.assertEquals("5432", engine.getDisplayedNumber())

        engine.setOperation(Operations.PLUS)

        engine.addNumber(1.0)
        engine.addNumber(0.0)
        Assert.assertEquals("10", engine.getDisplayedNumber())

        engine.calculate()
        Assert.assertEquals("5442", engine.getDisplayedNumber())

    }
}