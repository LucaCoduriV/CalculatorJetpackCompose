package com.example.calculator

import java.util.function.BinaryOperator

enum class Operations: BinaryOperator<Double>{
    PLUS {
        override fun apply(p0: Double, p1: Double): Double {
            return p0 + p1
        }
    },
    MINUS {
        override fun apply(p0: Double, p1: Double): Double {
            return p0 - p1
        }
    },
    MULTIPLY {
        override fun apply(p0: Double, p1: Double): Double {
            return p0 * p1
        }
    },
    DIVIDE {
        override fun apply(p0: Double, p1: Double): Double {
            return p0 / p1
        }
    },
    PURCENTAGE {
        override fun apply(p0: Double, p1: Double): Double {
            return p0 / 100 * p1
        }

    }
}
