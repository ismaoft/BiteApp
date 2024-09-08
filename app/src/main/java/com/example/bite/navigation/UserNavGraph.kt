package com.example.bite.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bite.ui.screens.HomeScreen
import com.example.bite.viewmodel.AuthViewModel

@Composable
fun UserNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, authViewModel = authViewModel) // Pasar AuthViewModel aquí
        }
        // Otras pantallas específicas para usuarios
    }
}


