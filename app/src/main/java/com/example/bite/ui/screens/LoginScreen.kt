package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.graphicsLayer
import com.example.bite.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
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

        // Logo
        Image(
            painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
            contentDescription = "Bite Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 20.dp)
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
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            Text("Password", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )
        }

        // Botón de Login
        Button(
            onClick = {
                // Navega siempre a la pantalla de Home
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .width(151.dp)
                .height(43.dp)
        ) {
            Text(text = "Sign In")
        }


        // Íconos de redes sociales
    }
}
