package com.bhardwaj.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorStates())
        private set

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.NumberEvent -> enterNumber(event.number)
            is CalculatorEvent.DecimalEvent -> enterDecimal()
            is CalculatorEvent.ClearEvent -> state = CalculatorStates()
            is CalculatorEvent.OperationEvent -> enterOperation(event.operation)
            is CalculatorEvent.CalculateEvent -> performCalculation()
            CalculatorEvent.DeleteEvent -> performDelete()
        }
    }

    private fun enterOperation(operation: CalculatorOperations) {
        if (state.firstNumber.isNotBlank()) state = state.copy(operation = operation)
    }

    private fun performDelete() {
        when {
            state.secondNumber.isNotBlank() -> state =
                state.copy(secondNumber = state.secondNumber.dropLast(1))

            state.operation != null -> state = state.copy(operation = null)

            state.firstNumber.isNotBlank() -> state =
                state.copy(firstNumber = state.firstNumber.dropLast(1))
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.firstNumber.contains(".") && state.firstNumber.isNotBlank()) {
            state = state.copy(firstNumber = state.firstNumber + ".")
        }

        if (!state.secondNumber.contains(".") && state.secondNumber.isNotBlank()) {
            state = state.copy(secondNumber = state.secondNumber + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.firstNumber.length >= MAX_NUM_LENGTH) return
            state = state.copy(firstNumber = state.firstNumber + number)
            return
        }

        if (state.secondNumber.length >= MAX_NUM_LENGTH) return
        state = state.copy(secondNumber = state.secondNumber + number)
        return
    }

    private fun performCalculation() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = when (state.operation) {
                is CalculatorOperations.Add -> firstNumber + secondNumber
                is CalculatorOperations.Subtract -> firstNumber - secondNumber
                is CalculatorOperations.Multiply -> firstNumber * secondNumber
                is CalculatorOperations.Divide -> firstNumber / secondNumber
                null -> return
            }

            state = state.copy(
                firstNumber = result.toString().take(15),
                operation = null,
                secondNumber = ""
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}