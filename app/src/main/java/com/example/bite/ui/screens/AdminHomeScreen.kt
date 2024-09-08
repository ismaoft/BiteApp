package com.example.bite.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.bite.navigation.Screen
import com.example.bite.ui.components.ActionButton
import com.example.bite.viewmodel.AuthViewModel

import android.util.Log

@Composable
fun AdminHomeScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Admin Home",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            ActionButton(
                text = "Logout",  // Botón de logout
                onClick = {
                    authViewModel.logout()  // Ejecuta logout
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.AdminHome.route) { inclusive = true }  // Elimina AdminHome del back stack
                        launchSingleTop = true  // Evita duplicados en el back stack
                    }
                }
            )
        }
    }
}

