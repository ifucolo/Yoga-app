package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.btnColor
import com.example.androiddevchallenge.ui.theme.buttonHeight
import com.example.androiddevchallenge.ui.theme.shapes


@Composable
fun ButtonMedium(
    text: String,
    paddingBottom: Dp = 0.dp,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(bottom = paddingBottom)
            .fillMaxWidth()
            .height(buttonHeight),
        shape = shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        onClick = {
            onClick.invoke()
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = btnColor()
        )
    }
}
