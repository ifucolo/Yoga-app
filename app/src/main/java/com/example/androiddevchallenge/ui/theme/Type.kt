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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

val KulimPark = FontFamily(
    Font(R.font.kulimpark_light, FontWeight.Light),
    Font(R.font.kulimpark_regular, FontWeight.Normal)
)

val Lato = FontFamily(
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = KulimPark,
        fontSize = 28.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 1.15.sp
    ),
    h2 = TextStyle(
        fontFamily = KulimPark,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 1.15.sp
    ),
    h3 = TextStyle(
        fontFamily = Lato,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        fontFamily = Lato,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        fontFamily = Lato,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.15.sp
    ),
    caption = TextStyle(
        fontFamily = KulimPark,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 1.15.sp
    )
)

@Composable
fun btnColor(): Color =
    if (isSystemInDarkTheme()) gray900 else white
