package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.ButtonMedium
import com.example.androiddevchallenge.ui.theme.*


@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
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
    WelcomeScreen(onSignUpClick = {}, onLoginClick = {  })
}