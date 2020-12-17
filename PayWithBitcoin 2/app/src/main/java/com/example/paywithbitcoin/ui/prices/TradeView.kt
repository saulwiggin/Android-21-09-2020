package com.example.paywithbitcoin.ui.prices

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String){
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
        ) {
            Text (
                text = "Welcome To Tradestation",
            )
        }
    }
}