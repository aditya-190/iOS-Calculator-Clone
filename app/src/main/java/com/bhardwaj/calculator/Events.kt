package com.bhardwaj.calculator

sealed class CalculatorEvent {
    data class NumberEvent(val number: Int): CalculatorEvent()
    data class OperationEvent(val operation: CalculatorOperations): CalculatorEvent()
    object ClearEvent: CalculatorEvent()
    object DeleteEvent: CalculatorEvent()
    object DecimalEvent: CalculatorEvent()
    object CalculateEvent: CalculatorEvent()
}

sealed class CalculatorOperations(val symbol: String) {
    object Add: CalculatorOperations("+")
    object Subtract: CalculatorOperations("-")
    object Multiply: CalculatorOperations("x")
    object Divide: CalculatorOperations("/")
}