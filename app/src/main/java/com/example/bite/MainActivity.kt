package com.example.bite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.bite.navigation.MainNavigation
import com.example.bite.ui.theme.BiteTheme
import com.example.bite.viewmodel.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiteTheme {
                val navController = rememberNavController()
                val authViewModel: AuthViewModel = viewModel()

                // Cargar la navegación principal que gestiona los roles
                MainNavigation(navController = navController, authViewModel = authViewModel)
            }
        }
    }
}
