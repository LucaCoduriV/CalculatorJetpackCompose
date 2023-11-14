package com.example.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()
    private val engine = CalculatorEngine()

    fun onNumberPress(n: Int) {
        engine.addNumber(n.toDouble())
        _result.value = engine.getDisplayedNumber()
    }

    fun onOperationPress(op:Operations) {
        engine.setOperation(op)
        _result.value = engine.getDisplayedNumber()
    }

    fun onEqualPress(){
        engine.equals()
        _result.value = engine.getDisplayedNumber()
    }

    fun onResetPress(){
        engine.reset()
        _result.value = engine.getDisplayedNumber()
    }

    fun onCommaPress(){
        engine.setFloatingPoint()
        _result.value = engine.getDisplayedNumber()
    }
}