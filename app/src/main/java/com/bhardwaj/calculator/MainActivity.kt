package com.bhardwaj.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bhardwaj.calculator.ui.theme.CalculatorTheme
import com.bhardwaj.calculator.ui.theme.LightGray
import com.bhardwaj.calculator.ui.theme.MediumGray
import com.bhardwaj.calculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state

                Calculator(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp),
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorStates,
    buttonSpacing: Dp = 8.dp,
    onEvent: (CalculatorEvent) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.firstNumber + (state.operation?.symbol ?: "") + state.secondNumber,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    buttonText = "AC", modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2F)
                        .weight(2F),
                    onClick = {
                        onEvent(CalculatorEvent.ClearEvent)
                    }
                )

                CustomButton(
                    buttonText = "Del", modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.DeleteEvent)
                    }
                )

                CustomButton(
                    buttonText = "/", modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.OperationEvent(CalculatorOperations.Divide))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    buttonText = "7", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(7))
                    }
                )

                CustomButton(
                    buttonText = "8", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(8))
                    }
                )

                CustomButton(
                    buttonText = "9", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(9))
                    }
                )

                CustomButton(
                    buttonText = "x", modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.OperationEvent(CalculatorOperations.Multiply))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    buttonText = "4", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(4))
                    }
                )

                CustomButton(
                    buttonText = "5", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(5))
                    }
                )

                CustomButton(
                    buttonText = "6", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(6))
                    }
                )

                CustomButton(
                    buttonText = "-", modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.OperationEvent(CalculatorOperations.Subtract))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    buttonText = "1", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(1))
                    }
                )

                CustomButton(
                    buttonText = "2", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(2))
                    }
                )

                CustomButton(
                    buttonText = "3", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(3))
                    }
                )

                CustomButton(
                    buttonText = "+", modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.OperationEvent(CalculatorOperations.Add))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CustomButton(
                    buttonText = "0", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2F)
                        .weight(2F),
                    onClick = {
                        onEvent(CalculatorEvent.NumberEvent(0))
                    }
                )

                CustomButton(
                    buttonText = ".", modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.DecimalEvent)
                    }
                )

                CustomButton(
                    buttonText = "=", modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onEvent(CalculatorEvent.CalculateEvent)
                    }
                )
            }
        }
    }
}