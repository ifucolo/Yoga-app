/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
