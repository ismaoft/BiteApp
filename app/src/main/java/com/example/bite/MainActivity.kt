package com.example.bite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bite.ui.screens.LoginScreen
import com.example.bite.ui.screens.register.RegisterScreen1
import com.example.bite.ui.screens.register.RegisterScreen2
import com.example.bite.ui.screens.register.RegisterScreen3
import com.example.bite.ui.theme.BiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiteTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(onLoginClick = { navController.navigate("register1") })
                    }
                    composable("register1") {
                        RegisterScreen1(navController)
                    }
                    composable("register2") {
                        RegisterScreen2(navController)
                    }
                    composable("register3") {
                        RegisterScreen3(navController)
                    }
                }
            }
        }
    }
}
