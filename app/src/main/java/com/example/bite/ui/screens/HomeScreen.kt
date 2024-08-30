package com.example.bite.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painter = rememberAsyncImagePainter("https://res.cloudinary.com/dlpnivtso/image/upload/v1724861579/BiteLogo_kkgbbc.png"),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(150.dp)
                            .padding(8.dp)
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO: Handle notification icon click*/ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = { /*TODO: Handle cart icon click*/ }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFF6F7DF)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFF6F7DF),
                contentColor = Color.Black
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = true, // Manejaremos la selección en el futuro
                    onClick = { /*TODO: Handle home click*/ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = false, // Manejaremos la selección en el futuro
                    onClick = { /*TODO: Handle search click*/ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false, // Manejaremos la selección en el futuro
                    onClick = { /*TODO: Handle profile click*/ }
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFF6F7DF))
            ) {
                // Image Cards
                ImageCard(
                    title = "Muffins",
                    imageUrl = "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904854/muffin_liacuk.png"
                )
                ImageCard(
                    title = "Cakes",
                    imageUrl = "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/cakes_ulod5b.png"
                )
                ImageCard(
                    title = "Brownies",
                    imageUrl = "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/brownie_p4tnyv.png"
                )
                ImageCard(
                    title = "Bread",
                    imageUrl = "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/bread_mwqirr.png"
                )
            }
        }
    )
}

@Composable
fun ImageCard(title: String, imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
            .clickable { /*TODO: Navigate to category*/ }
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Aquí reemplazarías con una NavController real
    HomeScreen(navController = rememberNavController())
}
