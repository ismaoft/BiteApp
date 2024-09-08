package com.example.bite.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bite.ui.screens.*
import com.example.bite.ui.screens.register.*
import com.example.bite.viewmodel.AuthViewModel



@Composable
fun MainNavigation(navController: NavHostController, authViewModel: AuthViewModel = viewModel()) {
    val currentUser = authViewModel.currentUser.collectAsState().value

    when (currentUser?.role) {
        "admin" -> AdminNavGraph(navController = navController, authViewModel = authViewModel)
        "user" -> UserNavGraph(navController = navController, authViewModel = authViewModel)
        else -> {
            NavHost(navController = navController, startDestination = Screen.Login.route) {
                composable(Screen.Login.route) {
                    LoginScreen(navController = navController, authViewModel = authViewModel)
                }
                composable(Screen.Register1.route) {
                    RegisterScreen1(navController = navController, authViewModel = authViewModel)
                }
                composable(Screen.Register2.route) {
                    RegisterScreen2(navController = navController, authViewModel = authViewModel)
                }
                composable(Screen.Register3.route) {
                    RegisterScreen3(navController = navController, authViewModel = authViewModel)
                }
                composable(Screen.Loading.route) {
                    LoadingScreen(navController = navController, authViewModel = authViewModel)
                }
            }
        }
    }
}


