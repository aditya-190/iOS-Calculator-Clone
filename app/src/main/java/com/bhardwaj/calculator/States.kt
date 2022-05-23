package com.bhardwaj.calculator

data class CalculatorStates(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperations? = null
)
