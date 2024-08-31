package com.example.bite.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bite.navigation.Screen

@Composable
fun RegisterScreen3(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val selectedItems = remember { mutableStateOf(listOf<String>()) }

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
                text = "What food allergies do you manage?",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Grid de imágenes
            val allergens = listOf(
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/gluten_allergen_p8wvrl.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/fish_allergen_plrv6k.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/egg_allergen_be0clr.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875906/crustaceans_allergen_zfl4wl.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/mustard_allergen_vq40zz.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875906/peanut_allergen_xzbvnb.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875906/nuts_allergen_mxac2k.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875908/sulfites_allergen_blpsyq.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875908/shellfish_allergen_w8vwap.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875908/sesame_allergen_umrebd.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/Group_2_qcy6eo.png",
                "https://res.cloudinary.com/dlpnivtso/image/upload/v1724875905/celery_allergen_yjqaok.png"
            )

            Column(modifier = Modifier.padding(top = 16.dp)) {
                for (rowIndex in 0 until 4) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        for (colIndex in 0 until 3) {
                            val index = rowIndex * 3 + colIndex
                            if (index < allergens.size) {
                                Image(
                                    painter = rememberAsyncImagePainter(allergens[index]),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clickable {
                                            val currentSelection = selectedItems.value.toMutableList()
                                            if (currentSelection.contains(allergens[index])) {
                                                currentSelection.remove(allergens[index])
                                            } else {
                                                currentSelection.add(allergens[index])
                                            }
                                            selectedItems.value = currentSelection
                                        }
                                        .padding(8.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Otro campo de texto
            Text("Other", modifier = Modifier.padding(start = 1.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6DF))
                    .padding(16.dp)
            )
        }

        // Botón de Save
        Button(
            onClick = {
                // Navegar a la pantalla de carga
                navController.navigate(Screen.Loading.route) {
                    popUpTo(Screen.Register3.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .width(151.dp)
                .height(43.dp)
        ) {
            Text(text = "Finish", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreen3Preview() {
    RegisterScreen3(navController = rememberNavController())
}

