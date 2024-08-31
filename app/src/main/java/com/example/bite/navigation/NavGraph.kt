package com.example.bite.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bite.ui.screens.LoginScreen
import com.example.bite.ui.screens.SplashScreen
import com.example.bite.ui.screens.HomeScreen
import com.example.bite.ui.screens.LoadingScreen
import com.example.bite.ui.screens.register.RegisterScreen1
import com.example.bite.ui.screens.register.RegisterScreen2
import com.example.bite.ui.screens.register.RegisterScreen3

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register1.route) {
            RegisterScreen1(navController = navController)
        }
        composable(Screen.Register2.route) {
            RegisterScreen2(navController = navController)
        }
        composable(Screen.Register3.route) {
            RegisterScreen3(navController = navController)
        }
        composable(Screen.Loading.route) {
            LoadingScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}
