package com.example.bite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.bite.navigation.NavGraph
import com.example.bite.ui.theme.BiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiteTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
