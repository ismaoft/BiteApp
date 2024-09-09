package com.example.bite.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bite.navigation.Screen
import com.example.bite.ui.components.CategorySection
import com.example.bite.ui.components.RestaurantSection
import com.example.bite.viewmodel.AuthViewModel
import com.example.bite.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,  // Recibe AuthViewModel como parámetro
    homeViewModel: HomeViewModel = viewModel() // Mantén HomeViewModel si es necesario
) {
    // Usa el HomeViewModel para cargar datos como categorías o restaurantes
    val categories by homeViewModel.categories.collectAsState()
    val categoryImages by homeViewModel.categoryImages.collectAsState()
    val restaurants by homeViewModel.restaurants.collectAsState()
    val restaurantImages by homeViewModel.restaurantImages.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
                            contentDescription = "Logo",
                            modifier = Modifier.size(100.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Home",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f) // Esto empuja los íconos a la derecha
                        )
                        IconButton(onClick = { /* Acción de notificación */ }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notificaciones",
                                tint = Color.White
                            )
                        }
                        IconButton(onClick = { /* Acción de carrito de compras */ }) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Carrito de compras",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00C3BE))
            )
        },
        bottomBar = {
            BottomNavigationBar (navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
        ) {
            // Sección de Categorías
            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp) // Añadir padding para que respire la UI
            ) {
                CategorySection(categories = categories, images = categoryImages)
            }

            // Sección de Restaurantes
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(8.dp) // Añadir padding para consistencia visual
            ) {
                RestaurantSection(restaurants = restaurants, images = restaurantImages)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = Color(0xFF00C3BE),
        contentColor = Color.White,
        tonalElevation = 8.dp // Añadir elevación para dar un efecto de profundidad
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = {
                Text(
                    "Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = true,
            onClick = { navController.navigate(Screen.Home.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = {
                Text(
                    "Search",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = false,
            onClick = {navController.navigate(Screen.SearchPage.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile") },
            label = {
                Text(
                    "Profile",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = false,
            onClick = { navController.navigate(Screen.Home.route) }
        )
    }
}
