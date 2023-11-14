package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    color: Color = Color(0xFF333333),
    large: Boolean = false,
    onClick: () -> Unit
) {
    val shape = if (large) {
        RoundedCornerShape(percent = 50)
    } else {
        CircleShape
    }
    val modifier = if (large) {
        Modifier
            .size(160.dp, 80.dp)
            .fillMaxWidth()
    } else {
        Modifier
            .size(80.dp)
    }
    Button(
        onClick = onClick,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text, fontSize = 20.sp, fontWeight = FontWeight(600))
    }
}

@Composable
fun Calculator(viewModel: CalculatorViewModel = viewModel()) {
    val result by viewModel.result.collectAsState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(result, fontSize = 50.sp)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(text = "C", color = Color(0xffa5a5a5)) {
                viewModel.onResetPress()
            }
            CustomButton(text = "+/-", color = Color(0xffa5a5a5)) {
            }
            CustomButton(text = "%", color = Color(0xffa5a5a5)) {
                viewModel.onOperationPress(Operations.PURCENTAGE)
            }
            CustomButton(text = "/", color = Color(0xFFff9d0e)) {
                viewModel.onOperationPress(Operations.DIVIDE)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(text = "7") {
                viewModel.onNumberPress(7)
            }
            CustomButton(text = "8") {
                viewModel.onNumberPress(8)
            }
            CustomButton(text = "9") {
                viewModel.onNumberPress(9)
            }
            CustomButton(text = "X", color = Color(0xFFff9d0e)) {
                viewModel.onOperationPress(Operations.MULTIPLY)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(text = "4") {
                viewModel.onNumberPress(4)
            }
            CustomButton(text = "5") {
                viewModel.onNumberPress(5)
            }
            CustomButton(text = "6") {
                viewModel.onNumberPress(6)
            }
            CustomButton(text = "-", color = Color(0xFFff9d0e)) {
                viewModel.onOperationPress(Operations.MINUS)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(text = "1") {
                viewModel.onNumberPress(1)
            }
            CustomButton(text = "2") {
                viewModel.onNumberPress(2)
            }
            CustomButton(text = "3") {
                viewModel.onNumberPress(3)
            }
            CustomButton(text = "+", color = Color(0xFFff9d0e)) {
                viewModel.onOperationPress(Operations.PLUS)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(text = "0", large = true) {
                viewModel.onNumberPress(0)
            }
            CustomButton(text = ".") {
                viewModel.onCommaPress()
            }
            CustomButton(text = "=", color = Color(0xFFff9d0e)) {
                viewModel.onEqualPress()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    CalculatorTheme {
        CalculatorEngine()
    }
}