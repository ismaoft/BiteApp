package com.example.bite.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen2(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7DF))
    ) {
        // Fondo diagonal
        Box(
            modifier = Modifier
                .offset(x = (-85).dp, y = (-40).dp)
                .size(width = 434.31.dp, height = 226.93.dp)
                .background(Color(0xFF41B9B2))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 43.dp)
                .align(Alignment.Center)
        ) {
            // Título
            Text(
                text = "Let's complete your profile...",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Campos de texto
            RegisterTextField("Date of Birth")
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField("Gender")
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField("Phone number")
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField("Country")
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField("State")
        }

        // Botón de Next
        Button(
            onClick = {
                navController.navigate("register3") // Navegar a la siguiente pantalla
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .width(151.dp)
                .height(43.dp)
        ) {
            Text(text = "NEXT")
        }
    }
}

@Composable
fun RegisterTextField(
    label: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = label, modifier = Modifier.padding(start = 1.dp))
        BasicTextField(
            value = TextFieldValue(""),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF6F6DF))
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreen2Preview() {
    RegisterScreen2(navController = rememberNavController())
}
