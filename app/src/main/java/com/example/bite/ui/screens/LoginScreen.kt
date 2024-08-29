package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun LoginScreen(onLoginClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7DF))
    ) {
        // Fondo diagonal
        Box(
            modifier = Modifier
                .offset(x = (-85).dp, y = (-40).dp)
                .size(width = 434.31.dp, height = 226.93.dp)
                .graphicsLayer(rotationZ = -22.88f)
                .background(Color(0xFF41B9B2))
        )

        // Logo - Imagen del logo
        Image(
            painter = rememberAsyncImagePainter(model = "https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .size(172.dp),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 43.dp)
                .align(Alignment.Center)
        ) {
            // Username Field
            Text("Username", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            Text("Password", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )
        }

        // Botón de Login
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .width(151.dp)
                .height(43.dp)
        ) {
            Text(text = "Sign In")
        }
    }
}
