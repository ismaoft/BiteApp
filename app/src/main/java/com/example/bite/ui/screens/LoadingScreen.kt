package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bite.navigation.Screen
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect

@Composable
fun LoadingScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7DF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
                contentDescription = "Bite Logo",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            CircularProgressIndicator(color = Color(0xFF41B9B2))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Adjusting Preferences...",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF41B9B2)
            )
        }
    }

    // Simular la carga antes de navegar al HomeScreen
    LaunchedEffect(Unit) {
        delay(3000) // 3 segundos de carga simulada
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Loading.route) { inclusive = true }
            launchSingleTop = true
        }
    }
}
