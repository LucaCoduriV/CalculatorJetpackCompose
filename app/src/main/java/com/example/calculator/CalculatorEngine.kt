package com.example.calculator

import java.text.DecimalFormat

class CalculatorEngine {
    private var numberA: Double? = null
    private var numberANeg: Boolean = false
    private var numberB: Double? = null
    private var numberBNeg: Boolean = false
    private var floating: Double = 1.0
    private var operation: Operations? = null

    fun calculate() {
        if (numberA == null || numberB == null || operation == null) {
            return
        }
        if(numberANeg){
            numberA = -numberA!!
        }
        if(numberBNeg){
            numberB = -numberB!!
        }
        numberA = operation!!.apply(numberA!!, numberB!!)
        numberB = null
    }

    fun setOperation(op: Operations) {
        if (numberA == null)
            return
        operation = op

        if(numberB != null)
            calculate()
    }

    fun changeSign(){
        if(numberB != null){
            numberBNeg = !numberBNeg
            return
        }

        if(numberA != null){
            numberANeg = !numberANeg
        }
    }

    fun getDisplayedNumber(): String {
        val formatter = DecimalFormat("0.#")
        val result = when {
            numberB != null -> if(numberBNeg) -numberB!! else numberB!!
            numberA != null -> if(numberANeg) -numberA!! else numberA!!
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

