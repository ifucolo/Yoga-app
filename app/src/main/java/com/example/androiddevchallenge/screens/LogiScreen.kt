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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.ButtonMedium
import com.example.androiddevchallenge.ui.theme.margin16
import com.example.androiddevchallenge.ui.theme.margin32
import com.example.androiddevchallenge.ui.theme.margin8

const val LOGIN_SCREEN_ID = "login_screen"

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        val imageBgId = if (isSystemInDarkTheme()) R.drawable.img_dark_login else R.drawable.img_light_login
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(imageBgId),
            contentDescription = "login"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(margin16),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = margin32),
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground
            )
            TextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier
                    .padding(bottom = margin8)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.onSurface),
                textStyle = MaterialTheme.typography.body1,
                label = { Text("Email address") },
            )
            TextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                modifier = Modifier
                    .padding(bottom = margin8)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.onSurface),
                label = { Text("Password") }
            )
            ButtonMedium(
                text = "LOG IN",
                paddingBottom = margin32,
                backgroundColor = MaterialTheme.colors.onSurface,
                onClick = {
                    onLoginClick.invoke()
                }
            )
            Row {
                Text(
                    modifier = Modifier
                        .padding(end = margin8),
                    text = "Don\'t have an account?",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = "SignUp",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenScreenPreview() {
    LoginScreen(onLoginClick = { })
}
