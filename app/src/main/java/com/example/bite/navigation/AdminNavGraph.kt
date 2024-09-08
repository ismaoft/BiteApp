package com.example.bite.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bite.ui.screens.AdminHomeScreen
import com.example.bite.ui.screens.LoginScreen
import com.example.bite.viewmodel.AuthViewModel

@Composable
fun AdminNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = Screen.AdminHome.route) {
        composable(Screen.AdminHome.route) {
            AdminHomeScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }
        // Otras pantallas específicas de administrador aquí
    }
}


