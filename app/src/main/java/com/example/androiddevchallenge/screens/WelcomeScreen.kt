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
package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.ButtonMedium
import com.example.androiddevchallenge.ui.theme.margin16
import com.example.androiddevchallenge.ui.theme.margin32
import com.example.androiddevchallenge.ui.theme.margin8

const val WELCOME_SCREEN_ID = "welcome_screen"

@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        val imageBgId = if (isSystemInDarkTheme()) R.drawable.img_dark_welcome else R.drawable.img_light_welcome

        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(imageBgId),
            contentDescription = "welcome"
        )

        val imgLogo = if (isSystemInDarkTheme()) R.drawable.ic_dark_logo else R.drawable.ic_light_logo

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(margin16),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(bottom = margin32),
                painter = painterResource(imgLogo),
                contentDescription = "logo"
            )
            ButtonMedium(
                text = "SIGN UP",
                paddingBottom = margin8,
                backgroundColor = MaterialTheme.colors.onSurface,
                onClick = {
                    onSignUpClick.invoke()
                }
            )
            ButtonMedium(
                text = "LOG IN",
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = {
                    onLoginClick.invoke()
                }
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onSignUpClick = {}, onLoginClick = { })
}
