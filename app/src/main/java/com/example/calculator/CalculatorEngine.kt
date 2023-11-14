package com.example.calculator

import java.text.DecimalFormat

class CalculatorEngine {
    private var numberA: Double? = null
    private var numberB: Double? = null
    private var floating: Double = 1.0
    private var operation: Operations? = null

    fun equals() {
        if (numberA == null || numberB == null || operation == null) {
            return
        }
        numberA = operation!!.apply(numberA!!, numberB!!)
        numberB = null
    }

    fun setOperation(op: Operations) {
        if (numberA == null)
            return
        operation = op
    }

    fun changeSign(){
        if(numberB != null){
            numberB = -numberB!!
            return
        }

        if(numberA != null){
            numberA = -numberA!!
        }
    }

    fun getDisplayedNumber(): String {
        val formatter = DecimalFormat("0.#")
        val result = when {
            numberB != null -> numberB
            numberA != null -> numberA
            else -> 0.0
        }
        return formatter.format(result)
    }

    fun addNumber(n: Double) {
        if (numberA == null) {
            numberA = n
            checkAndDivideFloating()
            return
        }

        if (operation == null) {
            numberA =
                when (floating) {
                    1.0 -> numberA!! * 10 + n
                    else -> numberA!! + n * floating
                }
            checkAndDivideFloating()
            return
        }

        if (numberB == null) {
            numberB = n
            checkAndDivideFloating()
            return
        }

        numberB =
            when (floating) {
                1.0 -> numberB!! * 10 + n
                else -> numberB!! + n * floating
            }
        checkAndDivideFloating()
    }

    private fun checkAndDivideFloating() {
        if (floating < 1)
            floating /= 10
    }

    fun setFloatingPoint() {
        if (floating == 1.0)
            floating /= 10
    }

    fun reset() {
        floating = 1.0
        numberA = null
        numberB = null
        operation = null
    }
}

