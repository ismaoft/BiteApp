package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.graphicsLayer
import com.example.bite.navigation.Screen
import com.example.bite.viewmodel.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bite.ui.components.ActionButton
import com.example.bite.ui.components.InputField

@Composable
fun LoginScreen(navController: NavHostController, authViewModel: AuthViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val currentUser by authViewModel.currentUser.collectAsState()
    val loginError by authViewModel.loginError.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7DF))
    ) {
        // Logo
        Image(
            painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
            contentDescription = "Bite Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 43.dp)
                .align(Alignment.Center)
        ) {
            // Reutilizando el componente InputField
            InputField(label = "Email", value = username, onValueChange = { username = it })
            Spacer(modifier = Modifier.height(16.dp))
            InputField(label = "Password", value = password, onValueChange = { password = it }, isPassword = true)

            Spacer(modifier = Modifier.height(24.dp))

// Reutilizando el componente ActionButton
            ActionButton(
                text = "Register",  // Aquí pasamos el texto del botón
                onClick = {         // Lambda para el evento de onClick
                    navController.navigate(Screen.Register1.route)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(
                text = "Sign In",  // Texto del botón
                onClick = {        // Acción del botón para hacer login
                    authViewModel.login(username, password)
                }
            )


            // Mostrar error de login si ocurre
            loginError?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it, color = Color.Red)
            }
        }

        // Redirigir según el rol del usuario autenticado
        currentUser?.let { user ->
            LaunchedEffect(user) {
                if (user.role == "admin") {
                    navController.navigate(Screen.AdminHome.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                        launchSingleTop = true
                    }
                } else {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
        }
    }
}

