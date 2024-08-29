package com.example.bite.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen1(navController: NavController, modifier: Modifier = Modifier) {
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
                .graphicsLayer(rotationZ = -22.88f)
                .background(Color(0xFF41B9B2))
        )

        // Texto de bienvenida
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to BITE!",
                fontSize = 24.sp,
                color = Color.Black
            )

            // Imagen debajo del texto de bienvenida
            Image(
                painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724879209/handgreet_ejo4mq.png"),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(60.dp),
                contentScale = ContentScale.Fit
            )

            // Descripción debajo de la imagen
            Text(
                text = "Hello, I guess you are new around here.\nYou can start using the application after sign up.",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp),
                lineHeight = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 43.dp)
                .align(Alignment.Center)
        ) {
            // Username
            Text("Username", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email Address
            Text("Email Address", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            Text("Password", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Repeat Password
            Text("Repeat Password", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )
        }

        // Botón de "Next"
        Button(
            onClick = { navController.navigate("register2") },
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

@Preview(showBackground = true)
@Composable
fun RegisterScreen1Preview() {
    // Usar un NavController real para la vista previa
    RegisterScreen1(navController = rememberNavController())
}
