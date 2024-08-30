package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bite.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C3BE)), // Color de fondo exacto de la imagen
        contentAlignment = Alignment.Center
    ) {
        // Cargar el logo desde la URL
        Image(
            painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
            contentDescription = "App Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(250.dp)
        )

        // Navegar a la pantalla de login después de 3 segundos
        LaunchedEffect(Unit) {
            delay(3000) // 3 segundos
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }
}
